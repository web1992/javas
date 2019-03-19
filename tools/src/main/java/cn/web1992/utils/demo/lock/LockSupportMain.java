package cn.web1992.utils.demo.lock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportMain {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(mainThread);
        }).start();

        System.out.println("start ...");
        LockSupport.park();
        System.out.println("end ...");
    }
}
