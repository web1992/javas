package cn.web1992.utils.demo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author web1992
 * @deta 2017/1/3
 * @desc synchronized 与 Lock 用法区别
 *
 * @see  Lock#lock() 获取锁，如果没有获取到锁，就会一直等待
 * @see  Lock#unlock() 在获取锁之后，必须手动释放锁
 *
 * @see  Lock#tryLock()  尝试获取锁，获取到锁，立即返回true
 * @see  Lock#tryLock(long, TimeUnit) 尝试获取锁,等待一段时间
 */
public class SynchronizedVsLock {
    public static void main(String[] args) {


//        Object lock=new Object();
        final Lock locknew = new ReentrantLock();

        final Condition condition = locknew.newCondition();

        Thread t1 = new Thread(() -> {

            try {
                locknew.lock();
                System.out.println("t1 wait");
                condition.await();
                System.out.println("t1 done");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                locknew.unlock();
            }

        });

        t1.start();


        Thread t2 = new Thread(() -> {

            try {
                System.out.println("get lock");
                locknew.lock();
                Thread.sleep(2000);

                System.out.println("t2 notify");
                condition.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                locknew.unlock();
            }

        });

        t2.start();

    }
}

/**
 * 　┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　┃　　　┃    神兽保佑,代码无bug
 * 　　┃　　　┃
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　 ┣┓
 * 　　┃　　　　 ┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 */