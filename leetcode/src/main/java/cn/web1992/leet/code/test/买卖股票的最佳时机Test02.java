package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @date 2022/3/7  11:05 下午
 * @link {https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/}
 */
public class 买卖股票的最佳时机Test02 {
    public static void main(String[] args) {

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(new 买卖股票的最佳时机Test02().maxProfit(prices));

    }


    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            if (minPrice > price) {// 在加个最低的时间去买
                minPrice = price;
            }

            if (price - minPrice > maxProfit) {// 计算利润，如果比之前的大，就卖掉股票
                maxProfit = price - minPrice;
            }

        }

        return maxProfit;
    }
}
