package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/3/24  10:57 PM
 * @link {https://leetcode-cn.com/problems/climbing-stairs/submissions/}
 * <pre>
 *     走台阶，每次只能走1次台阶，或者2个台阶，问，N 个台阶，总共有多少个走法？
 * </pre>
 */
public class 走台阶_动态规划 {

    public static void main(String[] args) {

        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {

        int[] dp = new int[n + 1];
        // dp[i]:台阶为i时，有几种走法
        // 初始化
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
