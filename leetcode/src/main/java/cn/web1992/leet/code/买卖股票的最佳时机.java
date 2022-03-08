package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/3/7  11:05 下午
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));

    }


    private static int maxProfit(int[] prices) {

        int len = prices.length;
        int[][] dp = new int[len][2];
        // 初始化第一个
        //          0 = 卖出股票
        // -prices[0] = 买入股票
        dp[0] = new int[]{0, -prices[0]};
        for (int i = 1; i < len; i++) {
            // 买入股票,     max(买入，卖出)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 卖出股票,     max(卖出,买入)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }

        return dp[len - 1][0];
    }
}
