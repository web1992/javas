package cn.web1992.utils.demo.juc;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 */
public class CDL {

    /**
     *  模拟一个开会的场景，10人到齐了，会议开始
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        // 10人
        int meeters = 10;
        CountDownLatch enter = new CountDownLatch(1);
        CountDownLatch arrive = new CountDownLatch(meeters);


        for (int i = 0; i < meeters; i++) {
            new Thread(() -> {
                try {
                    enter.await();
                    doWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    arrive.countDown();

                }

            }).start();
        }

        // 开始入场
        enter.countDown();
        // 等待人到齐
        arrive.await();
        // 人到齐了，开始开会
        System.out.println("meet begin...");
    }

    private static void doWork() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " arrive ...");
    }
}
