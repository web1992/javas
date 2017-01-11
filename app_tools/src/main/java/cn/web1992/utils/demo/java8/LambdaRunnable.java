package cn.web1992.utils.demo.java8;

import static java.lang.System.out;

/**
 * Created by web on 2017/1/11.
 */
public class LambdaRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> out.println("runnable");

        new Thread(runnable).start();
    }
}
