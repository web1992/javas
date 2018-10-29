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
import java.util.concurrent.TimeUnit;

public class SelectorServer2 {
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
        Selector selector = Selector.open();
        // ServerSocketChannel 只能处理这个 SelectionKey.OP_ACCEPT事件
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int n = selector.select();
            if (n == 0) {
                continue;
            }
            Iterator it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                it.remove();
                if (key.isAcceptable()) {
                    System.out.println("I am step 1/3");
                    // accept 返回一个新的链接scNew，改成这个不会改变 ssc
                    SocketChannel scNew;
                    scNew = ((ServerSocketChannel) key.channel()).accept();
                    if (scNew == null) {
                        continue;
                    }
                    System.out.println(scNew.getLocalAddress());
                    System.out.println("Receiving connection");
                    bb.clear();
                    bb.put(("I am service,time is " + System.currentTimeMillis()).getBytes("utf-8"));
                    bb.flip();
                    System.out.println("Writing msg to client");
                    while (bb.hasRemaining()) {
                        scNew.write(bb);
                    }
                    // 关闭连接,客户端在连接之后，会自动退出关闭
                    // 服务器，可以关闭客户端的连接
                    // scNew.close();
                    scNew.configureBlocking(false);
                    // 注册selector 设置感兴趣的事件
                    scNew.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                } else if (key.isConnectable()) {
                    System.out.println("I am step 2/3");
                } else if (key.isReadable()) {
                    SocketChannel sc = (SocketChannel) key.channel();

                    bb.clear();
                    int readLen = 0;
                    byte[] bytes = new byte[2048];
                    int count = 0;
                    while ((readLen = sc.read(bb)) > 0) {
                        bb.flip();
                        while (bb.hasRemaining()) {
                            bytes[count] = bb.get();
                            count++;
                        }
                        bb.clear();
                    }

                    System.out.println("receive msg is " + new String(bytes));

                } else if (key.isWritable()) {
                    SocketChannel sc = (SocketChannel) key.channel();

                    bb.clear();
                    bb.put("I am service too".getBytes("utf-8"));
                    bb.flip();
                    System.out.println("Writing msg to client");
                    while (bb.hasRemaining()) {
                        sc.write(bb);
                    }

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.println("key ops= " + key.readyOps());
                }

            }
        }
    }
}