package cn.web1992.utils.demo.java8.old;

/**
 * Created by Administrator on 2016/11/3.
 */
public class Demo {



    public static void main(String[] args){

        Runnable task= ()->{
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };


        task.run();



        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");


       Runnable runnable= () -> {

       };


    }
}
