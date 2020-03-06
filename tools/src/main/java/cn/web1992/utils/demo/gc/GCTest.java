package cn.web1992.utils.demo.gc;

/**
 * @author web1992
 * @date 2020/3/6  22:06
 * -XX:+PrintGCDateStamps -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGC -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * <p>
 * [GC (Allocation Failure) [PSYoungGen: 6366K->711K(9216K)] 6366K->4815K(19456K), 0.0025079 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]
 */
public class GCTest {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {

        byte[] b1, b2, b3, b4;
        b1 = new byte[2 * _1M];
        b2 = new byte[2 * _1M];
        b3 = new byte[2 * _1M];
        b4 = new byte[4 * _1M];
    }
}
