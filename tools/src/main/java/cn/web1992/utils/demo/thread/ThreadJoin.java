package cn.web1992.utils.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author web1992
 * @date 2020/10/5  15:03
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = createThread("A", 1);
        Thread threadB = createThread("B", 3);
        Thread threadC = createThread("C", 2);

        threadA.start();
        threadB.start();
        threadC.start();
        System.out.println("join start");
        threadB.join();
        System.out.println("B jon");
        threadA.join();
        System.out.println("A jon");
        threadC.join();
        System.out.println("C jon");


        TimeUnit.MICROSECONDS.sleep(2);


        for (int i = 0; i < 10; i++) {
            System.out.println("main run" + i);
        }
    }


    private static Thread createThread(String name, int time) {
        return new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        };
    }
}


