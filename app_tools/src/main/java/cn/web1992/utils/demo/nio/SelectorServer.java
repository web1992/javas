package cn.web1992.utils.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorServer {
    final static int DEFAULT_PORT = 9999;
    static ByteBuffer bb = ByteBuffer.allocateDirect(1024);

    public static void main(String[] args) throws IOException {
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        System.out.println("Server starting ... listening on port " + port);
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ServerSocket ss = ssc.socket();
        ss.bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        Selector s = Selector.open();
        ssc.register(s, SelectionKey.OP_ACCEPT);
        while (true) {
            int n = s.select();
            if (n == 0) {
                continue;
            }
            Iterator it = s.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                if (key.isAcceptable()) {
                    SocketChannel sc;
                    sc = ((ServerSocketChannel) key.channel()).accept();
                    if (sc == null) {
                        continue;
                    }
                    System.out.println("Receiving connection");
                    bb.clear();
                    bb.put("I am service".getBytes("utf-8"));
                    bb.flip();
                    System.out.println("Writing msg to client");
                    while (bb.hasRemaining()) {
                        sc.write(bb);
                    }
                    // 关闭连接,客户端在链接之后，会自动退出关闭
                    sc.close();
                }
                it.remove();
            }
        }
    }
}