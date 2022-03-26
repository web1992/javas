package cn.web1992.utils.demo.thread;

/**
 * @author web1992
 * @date 2020/10/5  15:03
 */
public class ThreadJoin2 {

    public static void main(String[] args) throws InterruptedException {

        // A>B>C
        Thread threadA = new Thread(() -> {

            System.out.println("threadA run");
        });

        Thread threadB = new Thread(() -> {
            try {
                threadA.join();
                System.out.println("threadB run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread threadC = new Thread(() -> {
            try {
                threadB.join();
                System.out.println("threadC run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadA.start();
        threadB.start();
        threadC.start();

    }


}


