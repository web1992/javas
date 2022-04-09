package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/3/7  11:05 下午
 * @link {https://www.bilibili.com/video/BV1cS4y137mg}
 * @link {https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/}
 */
public class 买卖股票的最佳时机2 {
    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(maxProfitGreedy(prices));

    }


    // 贪心，用左侧最低点作为买入点，比较右侧-左侧最低点的最大值就是所求最大利润
    public static int maxProfitGreedy(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            int profit = prices[i] - min;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
