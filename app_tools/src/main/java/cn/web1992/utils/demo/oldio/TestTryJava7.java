package cn.web1992.utils.demo.oldio;

import java.io.File;
import java.io.FileOutputStream;


public class TestTryJava7 {
    public static void main(String[] args) throws Exception {

        try (FileOutputStream outputStream = new FileOutputStream(new File("a.txt"))) {
            outputStream.write("abc".getBytes());
        }

    }
}
