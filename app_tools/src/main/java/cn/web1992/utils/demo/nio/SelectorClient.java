package cn.web1992.utils.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SelectorClient {
    final static int DEFAULT_PORT = 9999;
    static ByteBuffer bb = ByteBuffer.allocateDirect(8);

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

            byte[] bs = new byte[1024];
            int i = 0;
            int readLength = 0;
            int readCount = 0;
            while ((readLength = sc.read(bb)) != -1) {
                bb.flip();
                System.out.println("read length " + readLength);
                while (bb.hasRemaining()) {
                    //bs[i] = bb.get();
                    //i++;
                    bb.get(bs, readCount, readLength);
                    readCount += readLength;
                }
                bb.clear();
            }
            System.out.println("msg is: " + new String(bs));
            sc.close();
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