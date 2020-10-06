package cn.web1992.utils.demo.juc;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2020/3/16  21:41
 */
public class ConcurrentMapTest {

    public static void main(String[] args) {

        System.out.println("run");
        byte[] ba = new byte[1024 * 1024 * 10];
        Arrays.fill(ba, (byte) (1));
        System.out.println(ba);
    }
}
