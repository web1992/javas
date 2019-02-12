package cn.web1992.utils.demo.concurrent;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService demo
 * <p>
 * output
 * <pre>
 *     [pool-1-thread-1] run
 * </pre>
 *
 * @author web1992
 */
public class ExecutorsDemo {

    private final static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {

        try {
            // only print something
            executorService.submit(() -> System.out.println("[" + Thread.currentThread().getName() + "] run"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
