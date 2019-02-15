package cn.web1992.utils.demo.thread;

public class ThreadTest {
    public static void main(String[] args) {

        new Thread(() -> System.out.println("run")).start();

        new ThreadRun().start();

    }

}

class ThreadRun extends Thread {
    @Override
    public void run() {
        System.out.println("ThreadRun");
    }
}
