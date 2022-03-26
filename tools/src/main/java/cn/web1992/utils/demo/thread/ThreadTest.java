package cn.web1992.utils.demo.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> System.out.println("run")).start();

        Thread t1 = new ThreadRun();
        t1.start();

        TimeUnit.SECONDS.sleep(5);
        t1.interrupt();
        t1.join();


    }

}

class ThreadRun extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("sleep end and run ...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadRun");
    }
}
