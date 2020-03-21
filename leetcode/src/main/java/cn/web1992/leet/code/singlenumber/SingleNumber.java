package cn.web1992.leet.code.singlenumber;

/**
 * @author web1992
 * @date 2020/3/21  17:08
 * @link {https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/}
 * @link {https://www.cnblogs.com/zfLee/p/9330127.html}
 */
public class SingleNumber {

    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{4, 4, 6, 6, 7, 1, 2, 1, 2}));

        System.out.println(0 ^ 12345);
        System.out.println(~(7) + 1);
        System.out.println("0 | 1 = " + (0 | 1));
        System.out.println("0 & 1 = " + (0 & 1));
    }

    public static int singleNumber(int[] nums) {

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n = n ^ nums[i];
        }

        return n;
    }
}
