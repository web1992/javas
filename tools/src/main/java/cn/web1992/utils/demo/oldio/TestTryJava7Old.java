package cn.web1992.utils.demo.oldio;

import java.io.File;
import java.io.FileOutputStream;


public class TestTryJava7Old {
    public static void main(String[] args) throws Exception {

        FileOutputStream outputStream = new FileOutputStream(new File("a.txt"));
        outputStream.write("abc".getBytes());
        outputStream.close();
    }
}
