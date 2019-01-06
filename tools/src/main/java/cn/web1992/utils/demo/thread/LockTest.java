package cn.web1992.utils.demo.thread;

import sun.misc.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args){

        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
        reentrantLock.lock();

        Runnable r =()->{

            try {
                Thread.sleep(10000);
                reentrantLock.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        };

        new Thread(r).start();

        System.out.println("end");



    }
}
