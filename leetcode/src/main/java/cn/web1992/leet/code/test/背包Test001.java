package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @date 2022/4/27  23:21
 * @link {https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-1.html}
 * @link {https://www.bilibili.com/video/BV1cg411g7Y6} 背包问题
 */
public class 背包Test001 {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};// 物品的重量
        int[] value = {15, 20, 30};// 物品的价值
        int bagsize = 4;
        testweightbagproblem(weight, value, bagsize);
    }

    public static void testweightbagproblem(int[] weight, int[] value, int bagsize) {

        int wLen = weight.length;

        int[][] dp = new int[wLen + 1][bagsize + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= wLen; i++) {
            for (int j = 1; j <= bagsize; j++) {
                if (j < weight[i - 1]) {// i-1 i从一开始，所有-1
                    // j 是背包的容量，容量放不下物品i
                    // 放不下，则物品的价值则不变
                    dp[i][j] = dp[i - 1][j];// 此处 i-1 含义是上一个容量j,放物品i的价值
                } else {
                    int pre = dp[i - 1][j];
                    int cur = dp[i - 1][j - weight[i - 1]] + value[i - 1]; //weight,value 中的 i-1 -> i从一开始，所有-1
                    dp[i][j] = Math.max(pre, cur);
                }
            }
        }

        //打印dp数组
        for (int i = 0; i <= wLen; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
