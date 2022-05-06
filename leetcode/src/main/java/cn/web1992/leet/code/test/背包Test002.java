package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @date 2022/4/27  23:21
 * @link {https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-1.html}
 * @link {https://www.bilibili.com/video/BV1cg411g7Y6} 背包问题
 */
public class 背包Test002 {

    public static void main(String[] args) {

        int[] weight = {1, 3, 4};// 物品的重量
        int[] value = {15, 20, 30};// 物品的价值
        int bagsize = 4;

        testweightbagproblem(weight, value, bagsize);
    }

    // 0-1 背包问题: 只有两种情况；0=不装物品i，1=装物品i
    public static void testweightbagproblem(int[] weight, int[] value, int bagsize) {

        int wLen = weight.length;
        // dp[i] 物品
        // dp[j] 背包的容量
        int[][] dp = new int[wLen + 1][bagsize + 1];

        for (int i = 1; i <= wLen; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int p1 = dp[i - 1][j - weight[i - 1]] + value[i - 1];// 放入
                    int p2 = dp[i - 1][j];// 不放入
                    dp[i][j] = Math.max(p1, p2);
                }
            }
        }


        //打印dp数组
        for (int i = 0; i <= wLen; i++) {
            for (int j = 0; j <= bagsize; j++) {
                String s = String.format("f(%s,%s)=%s", i, j, dp[i][j]);
                System.out.println(s);
            }
            System.out.print("\n");
        }
    }
}
