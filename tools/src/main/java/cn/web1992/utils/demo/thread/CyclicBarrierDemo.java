package cn.web1992.utils.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("done ..."));

        IntStream.range(0, 5).forEach(i -> new Thread(() -> {
            try {
                cyclicBarrier.await();
                System.out.println("await done ..." + i);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start());

    }
}
