package cn.web1992.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author web1992
 * @date 2022/3/2  10:30 下午
 * @link {https://leetcode-cn.com/problems/3sum/}
 * @link {https://www.bilibili.com/video/BV1JL411c7fU}
 * @link {https://www.bilibili.com/video/BV1rb4y1U7BE}
 * @link {https://www.bilibili.com/video/BV1PL4y177Pg} 三数之和 搞笑版
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, 4};

        for (List<Integer> sum : threeSum(arr)) {
            System.out.println(sum.toString());
        }
    }

    // 双指针
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        int[] arrSorted = nums;

        for (int i = 0; i < arrSorted.length; i++) {
            int left = i + 1;
            int right = arrSorted.length - 1;

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
                    list.add(Arrays.asList(arrSorted[left], arrSorted[right], num));
                    // 去重
                    while (left < right && arrSorted[left] == arrSorted[left + 1]) {
                        left++;
                    }
                    // 去重
                    while (left < right && arrSorted[right] == arrSorted[right - 1]) {
                        right--;
                    }
                    // 指针移动
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    // sum >0
                    right--;
                }
            }
        }

        return list;
    }
}
