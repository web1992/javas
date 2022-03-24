package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/3/24  10:57 PM
 */
public class 走台阶 {

    public static void main(String[] args) {

        System.out.println(run(1));
        System.out.println(run(2));
        System.out.println(run(4));
    }

    private static int run(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return run(n - 1) + run(n - 2);
    }
}
