package cn.web1992.utils.demo.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            try {
                System.out.println("lock start");
                lock.lock();
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("unlock done");
                lock.unlock();
            }
        }).start();


        new Thread(() -> {

            try {
                TimeUnit.SECONDS.sleep(10);
                lock.lock();
                //lock.lock();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("main done");
        }).start();


    }
}
