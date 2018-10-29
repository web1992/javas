package cn.web1992.utils.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SelectorClient2 {
    final static int DEFAULT_PORT = 9999;
    static ByteBuffer bb = ByteBuffer.allocateDirect(1024);

    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        SocketChannel sc = null;
        try {
            sc = SocketChannel.open();
            InetSocketAddress addr = new InetSocketAddress("localhost", port);
            sc.connect(addr);
            sc.configureBlocking(false);


            Selector selector = Selector.open();
            sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);


            while (true) {

                int select = selector.select();

                if (select == 0) {
                    continue;
                }

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();

                    if (selectionKey.isReadable()) {
                        bb.clear();
                        // 读取服务端的消息 start
                        byte[] bs = new byte[1024];
                        int i = 0;
                        int readLength = 0;
                        int readCount = 0;

                        while ((readLength = sc.read(bb)) > 0) {
                            bb.flip();
                            while (bb.hasRemaining()) {
                                bb.get(bs, readCount, readLength);
                                readCount += readLength;
                            }
                            bb.clear();
                        }
                        System.out.println("msg is: " + new String(bs));
                    } else if (selectionKey.isWritable()) {

                        SocketChannel sc2 = (SocketChannel) selectionKey.channel();

                        bb.clear();
                        bb.put(("I am client,time is " + System.currentTimeMillis()).getBytes("utf-8"));
                        bb.flip();
                        System.out.println("Writing msg to service");
                        while (bb.hasRemaining()) {
                            sc2.write(bb);
                        }

                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // 其他的不处理
                        System.out.println("selectionKey is invalid" + selectionKey.readyOps());
                    }

                }

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (sc != null) {
                try {
                    sc.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }
    }
}