package cn.web1992.utils.demo.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author web1992
 * @deta 2016/11/29
 * @desc
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int OP_CONNECT = 1 << 3;
        int OP_WRITE = 1 << 2;
        int OP_4 = 1 << 4;
        int OP_5 = 1 << 5;

        System.out.println(OP_CONNECT);
        System.out.println(OP_WRITE);

        String s = Integer.toBinaryString(OP_CONNECT);
        String s1 = Integer.toBinaryString(OP_WRITE);
        System.out.println("----------");
        System.out.println(s);
        System.out.println(s1);
        System.out.println("----------");
        System.out.println(Integer.toBinaryString(OP_WRITE & OP_CONNECT));
        System.out.println(Integer.toBinaryString(OP_WRITE & OP_WRITE));
        System.out.println("----------");

        System.out.println(Integer.toBinaryString(OP_4));
        System.out.println(Integer.toBinaryString(OP_5));
        System.out.println("----------");
        System.out.println(Integer.toBinaryString(~1));
    }

}
