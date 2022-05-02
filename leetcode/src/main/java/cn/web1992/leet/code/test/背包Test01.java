package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @date 2022/4/27  23:21
 * @link {https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-1.html}
 * @link {https://www.bilibili.com/video/BV1cg411g7Y6} 背包问题
 */
public class 背包Test01 {

    public static void main(String[] args) {
        int[] itemSize = {1, 3, 4};// 物品的重量
        int[] value = {15, 20, 30};// 物品的价值
        int bagsize = 4;
        int maxVal = testweightbagproblem(itemSize, value, bagsize);
        System.out.println("maxVal=" + maxVal);
    }

    public static int testweightbagproblem(int[] itemSize, int[] value, int bagsize) {

        int itemLen = itemSize.length;// itemSize 数组中放了三个物品的重量，此数组的大小就是物品的数量
        // int itemLen = value.length;
        int[][] dp = new int[itemLen + 1][bagsize + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        //   0,1,2,3,4
        // 1
        // 2
        // 3
        for (int i = 1; i <= itemLen; i++) {
            int curItemIndex = i - 1;
            for (int j = 1; j <= bagsize; j++) {
                if (j < itemSize[curItemIndex]) {
                    dp[i][j] = dp[curItemIndex][j];
                } else {
                    // 装
                    int val1 = dp[curItemIndex][j - itemSize[curItemIndex]] + value[curItemIndex];
                    // 不装
                    int val2 = dp[curItemIndex][j];
                    // 取最大值
                    dp[i][j] = Math.max(val1, val2);
                }

            }
        }

        //打印dp数组
        for (int i = 0; i <= itemLen; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }


        return dp[itemLen][bagsize];
    }
}
