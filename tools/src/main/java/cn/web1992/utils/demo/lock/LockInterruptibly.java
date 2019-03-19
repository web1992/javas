package cn.web1992.utils.demo.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println("lock start");
                lock.lock();
            } finally {
                System.out.println("unlock done");
                lock.unlock();
            }
        }).start();

        try {
            lock.lock();
            //lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            new Thread(()->{
                try {
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("main done");

    }
}
