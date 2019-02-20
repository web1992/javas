package cn.web1992.utils.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

/**
 * desc: 模拟一个4人斗地主的场景，4个人都到了，斗地主开始
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("开始斗地主 ..."));

        IntStream.range(0, 4).forEach(i -> new Thread(() -> {
            try {
                System.out.println("等待开局 ..." + i);
                cyclicBarrier.await(1, TimeUnit.SECONDS);
                System.out.println("斗地主开始了 ..." + i);
            } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                e.printStackTrace();
            }
        }).start());

    }
}
