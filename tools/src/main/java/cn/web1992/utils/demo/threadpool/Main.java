package cn.web1992.utils.demo.threadpool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * demo for ScheduledThreadPoolExecutor
 */
public class Main {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);


        scheduledThreadPoolExecutor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " execute run ...");
        });

        // 第一个任务如果在 1秒内没有完成
        // 会等待第二个任务，知道第二个任务完成
        // 同时执行的任务只有一个
        // 如果执行的任务时，抛出了异常，该任务会终止
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getName() + " scheduleWithFixedDelay run ...");

            try {
                TimeUnit.SECONDS.sleep(1);
                throw new RuntimeException("error");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.SECONDS);


        // 第一个任务如果在 1秒内没有完成
        // 下一个任务，会继续执行
        // 同时执行的任务会超过2个
        // 如果执行的任务时，抛出了异常，该任务会终止
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                throw new RuntimeException("error");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " scheduleAtFixedRate run ...");
        }, 0, 1, TimeUnit.SECONDS);
    }
}
