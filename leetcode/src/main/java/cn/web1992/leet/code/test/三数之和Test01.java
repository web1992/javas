package cn.web1992.leet.code.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author web1992
 * @date 2022/3/2  10:30 下午
 * @link {https://www.bilibili.com/video/BV1JL411c7fU}
 * @link {https://www.bilibili.com/video/BV1rb4y1U7BE}
 * @link {https://leetcode-cn.com/problems/3sum/}
 */
public class 三数之和Test01 {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 0, 1, 1, 2, -1, 4};
        for (List<Integer> _arr : threeSum(arr)) {
            System.out.println(_arr.toString());
        }
    }

    // 双指针
    private static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        // [-1, -1, 0, 1, 2, 4]
        int[] arrSorted = Arrays.stream(nums).sorted().toArray();
        int len = arrSorted.length;

        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            int num = arrSorted[i];
            if (num > 0) {
                continue;
            }
            if (i > 0 && num == arrSorted[i - 1]) {
                continue;
            }
            while (left < right) {
                int sum = arrSorted[left] + num + arrSorted[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(arrSorted[left], num, arrSorted[right]));
                    while (left < right && arrSorted[left] == arrSorted[left + 1]) {
                        left++;
                    }
                    while (left < right && arrSorted[right] == arrSorted[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {// sum>0
                    right--;
                }
            }
        }

        return ans;
    }
}
