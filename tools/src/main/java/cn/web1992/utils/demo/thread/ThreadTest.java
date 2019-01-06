package cn.web1992.utils.demo.thread;

import java.io.IOException;

public class ThreadTest {
    public static void main(String[] args) throws IOException {
      Thread t =  new Thread(()->System.out.println("run"));

      t.setDaemon(true);
      t.start();

      System.in.read();

    }
}
