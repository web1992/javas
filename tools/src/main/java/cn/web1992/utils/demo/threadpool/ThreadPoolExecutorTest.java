package cn.web1992.utils.demo.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author web1992
 * @date 2019/12/4  09:10
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {

        // ArrayBlockingQueue 满了之后，后续新创建的任务，才会继续创建新的线程，直到 maximumPoolSize
        ThreadPoolExecutor poll = new ThreadPoolExecutor(1,
                9,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));


        for (int i = 0; i < 1000; i++) {
            poll.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("getPoolSize " + poll.getPoolSize());
            System.out.println("getCorePoolSize " + poll.getCorePoolSize());
            System.out.println("getQueue " + poll.getQueue().size());
        }

    }
}
