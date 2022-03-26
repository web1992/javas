package cn.web1992.utils.demo.thread;

/**
 * @author web1992
 * @date 2020/10/5  15:03
 */
public class ThreadJoin3 {

    public static void main(String[] args) throws InterruptedException {

        Thread threadC = new Thread(() -> {
            try {
                System.out.println("threadC run");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        Thread threadB = new Thread(() -> {
            try {
                threadC.join();
                System.out.println("threadB run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        // C>B>A
        Thread threadA = new Thread(() -> {

            try {
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("threadA run");

        });


        threadA.start();
        threadB.start();
        threadC.start();

    }


}


