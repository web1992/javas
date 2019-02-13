package cn.web1992.utils.demo.thread;


public class ThreadTest {
    public static void main(String[] args) {

        Thread t = new Thread(() -> System.out.println("run " + Thread.currentThread().getName()));

        t.setDaemon(true);
        t.start();

        //System.in.read();

    }
}
