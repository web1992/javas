package cn.web1992.utils.demo.feature;


import java.util.concurrent.*;

public class FeatureDemo {
    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(1);
        try {
            // Callable
            Callable<String> callable = () -> {
                TimeUnit.SECONDS.sleep(3L);
                return "ok";
            };
            Future<String> future = executor.submit(callable);
            System.out.println("isCancelled = " + future.isCancelled());
            System.out.println("isDone = " + future.isDone());
            String result = null;

            new Thread(() -> {
                //boolean cancel = future.cancel(true);
                //System.out.println("cancel result = "+cancel);

            }).start();
            try {
                result = future.get(1,TimeUnit.SECONDS);

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(result);
            System.out.println("isCancelled = " + future.isCancelled());
            System.out.println("isDone = " + future.isDone());
            // Runnable
            Runnable runnable = () -> {
                System.out.println("runnable run");
            };
            executor.submit(runnable);
        } finally {
            executor.shutdown();
        }
    }
}
