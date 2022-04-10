package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/3/24  8:22 AM
 * @link {https://www.leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/}
 * @link {https://www.bilibili.com/video/BV1qa411q7kr}
 */
public class N个筛子的点数 {

    public static void main(String[] args) {

        double[] ans = new N个筛子的点数().dicesProbability(2);
        System.out.println("ans.length >>>" + ans.length);
        for (double an : ans) {
            System.out.println(an);
        }

    }

    /**
     * 假设我已经有了最后一次的结果，在最后一次的结果上面，然后继续倒推
     *
     * <Pre>
     * 动态规划/记忆化搜索
     * </Pre>
     *
     * @param n 筛子的个数人
     * @return
     */
    public double[] dicesProbability(int n) {

        // 一个筛子有6个点数，6^n 筛子点数的总的情况
        double total = Math.pow(6, n);
        double[] ans = new double[6 * n - n + 1];

        // 初始化缓存
        // 第一维是筛子的个数
        // 第二维是筛子的点数之和
        int[][] cache = new int[n + 1][6 * n + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < 6 * n + 1; j++) {
                cache[i][j] = -1;
            }
        }
        // getCount 中的是从1开始的
        for (int i = 1; i <= 6; i++) {
            cache[1][i] = 1;
        }

        for (int i = n * 6; i >= n; i--) {
            int count = getCount(cache, n, i);
            ans[i - n] = count * 1.0d / total;
        }

        return ans;

    }


    /**
     * @param n   筛子的个数
     * @param sum 筛子的点数的之和
     * @return 筛子的个数=n，筛子的点数=sum 的情况
     */
    private int getCount(int[][] cache, int n, int sum) {
        // 3 个筛子，和为14的情况
        // (2 + 1) 个筛子，和为14的情况
        if (n < 1 || sum > n * 6) {
            return 0;
        }

        if (cache[n][sum] != -1) {
            return cache[n][sum];
        }

        int count = 0;
        // 此处的 point 为筛子的点数
        // sum - i >= n - 1 => (剩下的筛子和 >= 剩余筛子的个数)
        // point 1-6 点
        for (int point = 1; point <= 6 && sum - point >= n - 1; point++) {
            if (cache[n - 1][sum - point] != -1) {
                count += cache[n - 1][sum - point];
            } else {
                // n-1   消耗一个筛子
                // sum-point 减去当前筛子的点数
                int c = getCount(cache, n - 1, sum - point);
                cache[n - 1][sum - point] = c;// 放入cache
                count += c;
            }
        }

        return count;
    }

}
