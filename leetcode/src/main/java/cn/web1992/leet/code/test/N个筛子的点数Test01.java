package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @date 2022/3/24  8:22 AM
 * @link {https://www.leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/}
 * @link {https://www.bilibili.com/video/BV1qa411q7kr}
 */
public class N个筛子的点数Test01 {

    public static void main(String[] args) {

        double[] ans = new N个筛子的点数Test01().dicesProbability(2);
        System.out.println("ans.length >>>" + ans.length);
        for (double an : ans) {
            System.out.println(an);
        }

    }

    //   筛子的个数     => 筛子的点数范围
    // 1,2,3,4,5,6 *1 => 1-6
    // 1,2,3,4,5,6 *2 => 2-12
    // 1,2,3,4,5,6 *3 => 3-18
    public double[] dicesProbability(int n) {

        double[] ans = new double[6 * n - n + 1];
        double total = Math.pow(6, n);

        // [筛子的个数][筛子的点数之和]
        int[][] cache = new int[n + 1][6 * n + 1];

        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < 6 * n + 1; j++) {
                cache[i][j] = -1;
            }
        }
        for (int i = 1; i <= 6; i++) {
            cache[1][i] = 1;
        }

        for (int i = n * 6; i >= n; i--) {
            int count = getCount(cache, n, i);
            ans[i - n] = count / total;
        }
        return ans;

    }


    /**
     * @param n   筛子的个数
     * @param sum 筛子的点数的之和
     * @return 筛子的个数=n，筛子的点数=sum 的情况
     */
    private int getCount(int[][] cache, int n, int sum) {

        int count = 0;

        if (n < 1 || sum > n * 6) {
            return 0;
        }

        if (cache[n][sum] != -1) {
            return cache[n][sum];
        }

        for (int point = 1; point <= 6 && sum - point >= n - 1; point++) {

            if (cache[n - 1][sum - point] != -1) {
                count += cache[n - 1][sum - point];
            } else {
                int c = getCount(cache, n - 1, sum - point);
                cache[n - 1][sum - point] = c;
                count += c;
            }

        }

        return count;
    }

}
