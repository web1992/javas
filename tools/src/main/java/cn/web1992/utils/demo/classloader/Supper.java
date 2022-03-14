package cn.web1992.utils.demo.classloader;

/**
 * @author web1992
 * @date 2022/3/14  10:41 上午
 */
public class Supper {
    public static int A = 1;

    static {
        A = 2;
    }

    static class Sub {
        public static final int B = A;

        public static void main(String[] args) {
            System.out.println(B);
        }
    }
}
