package cn.web1992.utils.demo.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author web1992
 */
public class ExecutorsDemo {
    private final static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        try {

            // execute
            executorService.execute(() -> System.out.println("[" + Thread.currentThread().getName() + "] run execute"));

            // submit
            Future<String> submit = executorService.submit(() -> {
                System.out.println("[" + Thread.currentThread().getName() + "] run submit");
                // sleep 3 seconds
                TimeUnit.SECONDS.sleep(3);
                return "ok";
            });

            String s = submit.get();
            System.out.println("result " + s);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           // executorService.shutdown();
        }
    }
}
