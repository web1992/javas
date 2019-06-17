

package cn.web1992.utils.demo.java8;


import org.junit.jupiter.api.Assertions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // demo-1
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture
                .supplyAsync(() -> 1)
                .thenApply(t -> t * 2)
                .thenApply(t -> t * 100)
                .thenAccept(System.out::println);

        System.out.println(voidCompletableFuture.get());

        // demo-2
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        Assertions.assertTrue(cf.isDone());
        Assertions.assertEquals("message", cf.getNow(null));

        // demo-3
        CompletableFuture<String> cf2 = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            System.out.println(Thread.currentThread().getName());
            Assertions.assertTrue(Thread.currentThread().isDaemon());
            randomSleep();
            return s.toUpperCase();
        });
        Assertions.assertNull(cf2.getNow(null));
        Assertions.assertEquals("MESSAGE", cf2.join());

        // demo-4

        String original = "Message";
        CompletableFuture cf3 = CompletableFuture.completedFuture(original)
                .thenApplyAsync(CompletableFutureDemo::delayedLowerCase);

        CompletableFuture cf4 = cf3.applyToEither(
        CompletableFuture.completedFuture(original).thenApplyAsync(CompletableFutureDemo::delayedLowerCase),
                s -> s + " from applyToEither");

        Assertions.assertTrue(((String)cf4.join()).endsWith(" from applyToEither"));

    }

    private static String delayedLowerCase(String s) {
        randomSleep();
        return s.toUpperCase();
    }

    private static void randomSleep() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
