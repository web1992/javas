package cn.web1992.utils.demo.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTryDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread mainThread = Thread.currentThread();

        new Thread(() -> {
            try {
                mainThread.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        try {

            TimeUnit.SECONDS.sleep(2);
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
