package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/4/30  23:27
 */
public class 走台阶_递归 {

    public static void main(String[] args) {

        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {

        int[] mem = new int[n];
        for (int i = 0; i < n; i++) {
            mem[i] = -1;
        }
        return climbStairs0(mem, n);
    }

    public static int climbStairs0(int[] mem, int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int n1 = 0;
        if (mem[n - 1] != -1) {
            n1 = mem[n - 1];
        } else {
            n1 = climbStairs0(mem, n - 1);
            mem[n - 1] = n1;
        }
        int n2 = 0;
        if (mem[n - 2] != -1) {
            n2 = mem[n - 2];
        } else {
            n2 = climbStairs0(mem, n - 2);
            mem[n - 2] = n2;
        }

        return n1 + n2;
    }
}
