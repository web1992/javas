package cn.web1992.utils.demo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch cdl = new CountDownLatch(2);

        Runnable r = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("sleep end");
                cdl.countDown();
                cdl.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r).start();
        cdl.await();

        System.out.println("end");


    }
}
