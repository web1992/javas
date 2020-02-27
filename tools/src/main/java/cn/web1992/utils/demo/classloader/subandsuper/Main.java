package cn.web1992.utils.demo.classloader.subandsuper;

/**
 * @author web1992
 * @date 2020/2/27  20:15
 * -XX:+TraceClassLoading
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Sub.value);
    }
}
