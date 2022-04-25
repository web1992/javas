package cn.web1992.leet.code;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author web1992
 * @date 2022/4/25  11:29
 * @link {https://leetcode-cn.com/problems/chou-shu-lcof/}
 * @link {http://www.chusan.com/zhongkao/114048.html} 质因数
 * @link {https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/thinkings/heap#li-er-313.-chao-ji-chou-shu} 超级丑数
 */
public class 丑数 {

    public static void main(String[] args) {

        System.out.println("nthUglyNumber=" + nthUglyNumber(10));
        System.out.println("nthUglyNumber2=" + nthUglyNumber2(10));
    }

    // 最小堆
    public static int nthUglyNumber(int n) {

        int[] arr = new int[]{2, 3, 5};
        Set<Long> seen = new HashSet<>(100);

        PriorityQueue<Long> queue = new PriorityQueue<>(100);
        seen.add(1L);
        queue.offer(1L);

        Long cur = 0L;
        for (int i = 0; i < n; i++) {
            cur = queue.poll();
            for (int j = 0; j < arr.length; j++) {
                Long num = cur * arr[j];
                if (seen.add(num)) {
                    queue.offer(num);
                }
            }
        }

        return cur.intValue();
    }

    // 动态规划
    public static int nthUglyNumber2(int n) {


        int[] dp = new int[n];
        dp[0] = 1;

        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }

            if (dp[i] == dp[p5] * 5) {
                p5++;
            }

        }
        return dp[n - 1];
    }
}
