package cn.web1992.utils.demo.queue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPollTest {
    public static void main(String[] args) throws InterruptedException {
        RejectedExecutionHandler reh = (Runnable r, ThreadPoolExecutor executor) -> {
            System.err.println("the task " + r.toString() + " is rejected ... poll status " + executor.toString());
        };

        // reh = new ThreadPoolExecutor.DiscardOldestPolicy();


        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2), reh);

//         ExecutorService tpe = Executors.newSingleThreadExecutor();
//         ExecutorService tpe = Executors.newCachedThreadPool();
//        ExecutorService tpe = Executors.newFixedThreadPool(5);


        System.out.println(tpe.toString());


        IntStream.range(0, 10).forEach(
                index -> {
                    tpe.execute(() -> {
                        try {
                            TimeUnit.SECONDS.sleep(1L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("run = " + index);
                    });
                }
        );

        System.out.println("end");
        System.out.println(tpe);
//        System.out.println(tpe.getActiveCount());

//        TimeUnit.SECONDS.sleep(2L);
//        System.out.println(tpe.getActiveCount());
        tpe.shutdown();


    }
}
