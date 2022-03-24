package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/3/24  10:57 PM
 * <pre>
 *     走台阶，每次只能走1次台阶，或者2个台阶，问，N 个台阶，总共有多少个走法？
 * </pre>
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


        return run(n - 1) //  // 一次走1个台阶
                + run(n - 2); // 一次走2个台阶
    }
}
