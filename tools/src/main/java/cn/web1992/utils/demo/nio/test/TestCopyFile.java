package cn.web1992.utils.demo.nio.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author web1992
 * @deta 2016/11/30
 * @desc nio复制文件 README.md
 */
public class TestCopyFile {

    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream("README_copy.md");

        FileInputStream fin = new FileInputStream("README.md");


        FileChannel finChannel = fin.getChannel();
        FileChannel foutChannel = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(100);


        while (true) {
            buffer.clear();
            int readL = finChannel.read(buffer);
            if (-1 == readL) {
                break;
            }
            buffer.flip();
            foutChannel.write(buffer);
        }

    }
}
