package cn.web1992.utils.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Thread t = new Thread(() -> {
            try {
                reentrantLock.lock();
                System.out.println("await start");
                condition.await();
                System.out.println("await end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });
        t.start();

        // System.out.println("main run");
        // System.out.println("interrupt");
        t.interrupt();

        try {
            reentrantLock.lock();
            System.out.println("main signal");
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }


    }
}
