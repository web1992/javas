package cn.web1992.utils.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(() -> {
            try {

                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock ...");
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                System.out.println(Thread.currentThread().getName() + " unlock ...");
            }
        }).start();


        try {
            TimeUnit.SECONDS.sleep(1);
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock again ...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName() + " unlock again ...");
        }
    }
}
