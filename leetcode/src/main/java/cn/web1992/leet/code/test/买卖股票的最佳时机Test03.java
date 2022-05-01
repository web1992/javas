package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @date 2022/3/7  11:05 下午
 * @link {https://www.bilibili.com/video/BV1cS4y137mg}
 * @link {https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/}
 * @implNote 设计一个算法来计算你所能获取的最大利润
 */
public class 买卖股票的最佳时机Test03 {
    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(new 买卖股票的最佳时机Test03().maxProfit(prices));

    }


    // 贪心算法
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);// 最低价格
            int profit = price - minPrice;// 计算利润
            maxProfit = Math.max(profit, maxProfit);// 最大利润
        }

        return maxProfit;
    }
}
