package cn.web1992.utils.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class SSC {

    private static final Integer PORT = 9999;
    static ByteBuffer bb = ByteBuffer.allocateDirect(18);

    public static void main(String[] args) throws IOException {

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(PORT));
        System.out.println("server start at port: " + PORT);
        // config no blocking
        ssc.configureBlocking(false);

        Selector selector = Selector.open();

        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int num = selector.select();

            if (0 == num) {
                System.out.println("no invalid selector");
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()) {
                    SocketChannel client = ((ServerSocketChannel) (selectionKey.channel())).accept();

                    if (null == client) {
                        continue;
                    }
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);

                    bb.clear();
                    bb.putLong(new Date().getTime());
                    bb.flip();

                    while (bb.hasRemaining()) {
                        client.write(bb);
                    }

                    client.close();

                } else if (selectionKey.isReadable()) {
                    SocketChannel client = (SocketChannel) selectionKey.channel();

                    if (null == client) {
                        continue;
                    }

                    bb.clear();

                    while (client.read(bb) != -1) {
                        bb.flip();
                        while (bb.hasRemaining()) {
                            System.out.print((char) bb.get());
                        }
                    }
                }


                // remove
                iterator.remove();

            }
        }

    }

    /**
     * 客户端
     */
    static class Client {

        public static void main(String[] args) throws IOException {

            SocketChannel sc = SocketChannel.open();

            sc.connect(new InetSocketAddress("localhost", PORT));

            long time = 0;

            while (sc.read(bb) != -1) {
                bb.flip();

                while (bb.hasRemaining()) {
                    time <<= 8;
                    time |= bb.get() & 255;
                }
                bb.clear();
            }

            bb.clear();

            bb.put("I am client ...".getBytes());
            bb.flip();
            while (bb.hasRemaining()) {
                sc.write(bb);
            }
            bb.clear();
            sc.close();
            System.out.println("get time from server: " + new Date(time));
        }
    }

}