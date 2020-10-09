package cn.web1992.utils.demo.thread;

import java.util.LinkedList;

/**
 * @author web1992
 * @date 2020/10/9  20:46
 */
public class GuardedSuspensionQueue<T> {


    private final LinkedList<T> linkedList = new LinkedList<>();
    private final int maxSize = 10;

    final Object lock = new Object();

    public void offer(T t) throws InterruptedException {

        synchronized (lock) {
            while (linkedList.size() >= maxSize) {
                lock.wait();
            }
            linkedList.addLast(t);
            lock.notifyAll();
        }


    }


    public T get() throws InterruptedException {

        synchronized (lock) {

            while (linkedList.isEmpty()) {
                lock.wait();
            }

            T first = linkedList.removeFirst();
            lock.notifyAll();
            return first;
        }


    }
}



