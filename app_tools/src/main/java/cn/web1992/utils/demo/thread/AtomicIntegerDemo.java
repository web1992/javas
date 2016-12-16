package cn.web1992.utils.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author web1992
 * @deta 2016/12/13
 * @desc AtomicInteger 在过多线程对共享数据进行操作（在这里就是累加）时，
 * 可以保证线程的安全，
 * 线程R1,线程R2 在对 MyPool.value 进行累加是，如果是  public static int value =  0;
 * 等循环结束之后，结果不一定是200，而AtomicInteger可以保证结果是200
 */
public class AtomicIntegerDemo {

    private static Object lock = new Object();


    public static void main(String[] args) {


        new Thread(new R1()).start();
        new Thread(new R2()).start();

        while (true) {
            System.out.println("the result value=" + MyPool.value);
            if (MyPool.value.intValue() >= 200) {
                System.out.println("the result value=" + MyPool.value);
                break;
            }

        }

    }


    static class R1 implements Runnable {


        @Override
        public void run() {
            System.out.println("R1 run");
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MyPool.value.incrementAndGet();
            }
        }
    }

    static class R2 implements Runnable {

        @Override
        public void run() {
            System.out.println("R2 run");
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MyPool.value.incrementAndGet();
            }
        }
    }


    static class MyPool {
        public static AtomicInteger value = new AtomicInteger(0);
//        public static int value =  0;

    }
}

