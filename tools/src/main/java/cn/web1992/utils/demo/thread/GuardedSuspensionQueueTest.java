package cn.web1992.utils.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author web1992
 * @date 2020/10/9  20:46
 */
public class GuardedSuspensionQueueTest {
    public static void main(String[] args) {

        GuardedSuspensionQueue<String> queue = new GuardedSuspensionQueue<>();

        new Thread(() -> {

            try {
                while (true) {
                    String s = queue.get();
                    System.out.println("get  is " + s);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {

            try {
                while (true) {
                    System.out.println("put suc");
                    queue.offer("A");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
