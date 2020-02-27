package cn.web1992.utils.demo.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest {
    public static void main(String[] args) {

        new Thread(() -> System.out.println("run")).start();

        Thread t1 = new ThreadRun();
        t1.start();
        t1.interrupt();


}

}

class ThreadRun extends Thread {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadRun");
    }
}
