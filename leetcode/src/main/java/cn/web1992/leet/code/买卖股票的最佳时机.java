package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/3/7  11:05 下午
 * @link {https://www.bilibili.com/video/BV1cS4y137mg}
 * @link {https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/}
 * @implNote 设计一个算法来计算你所能获取的最大利润
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(new 买卖股票的最佳时机().maxProfit(prices));

    }


    // 动态规划
    public int maxProfit(int[] prices) {

        int len = prices.length;
        int[][] dp = new int[len][2];// 二维数组，[0]=出售股票，[1]=买入股票
        // 初始化第一个
        // [0]          0 = 出售股票
        // [1] -prices[0] = 买入股票
        dp[0] = new int[]{0, -prices[0]};
        for (int i = 1; i < len; i++) {
            int pre = i - 1;// 前一天
            //              max(不操作，买入股票)
            dp[i][1] = Math.max(dp[pre][1], dp[pre][0] - prices[i]);// 前一天 -> 今天
            //              max(不操作，出售股票)
            dp[i][0] = Math.max(dp[pre][0], dp[pre][1] + prices[i]);
        }

        return dp[len - 1][0];
    }
}
