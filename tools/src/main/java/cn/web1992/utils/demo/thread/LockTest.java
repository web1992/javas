package cn.web1992.utils.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
        // 在这里处理共享资源
        System.out.println("locking ...");
        reentrantLock.unlock();
        System.out.println("end");

    }
}
