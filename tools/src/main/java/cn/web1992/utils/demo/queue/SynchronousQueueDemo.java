package cn.web1992.utils.demo.queue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author web1992
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            String takeObj = null;
            try {
                takeObj = synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(takeObj);
        }).start();

        // put 一直会阻塞，除非有 take 操作
        synchronousQueue.put("1");
        System.out.println("put done");

    }
}
