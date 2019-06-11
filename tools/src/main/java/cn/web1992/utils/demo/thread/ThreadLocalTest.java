package cn.web1992.utils.demo.thread;


import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    private final static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            String name = Thread.currentThread().getName();
            System.out.println("ThreadLocal init " + name);
            System.out.println(this);
            return "ThreadLocal " + name;
        }
    };


    public static void main(String[] args) {

        System.out.println(THREAD_LOCAL.get());
        new Thread(() -> {

            System.out.println("thread " + THREAD_LOCAL.get());
            THREAD_LOCAL.set("new value");
            System.out.println("thread after set " + THREAD_LOCAL.get());

        }).start();

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main " + THREAD_LOCAL.get());
    }
}
