package cn.web1992.leet.code.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author web1992
 * @date 2022/3/2  10:30 下午
 * @link {https://leetcode-cn.com/problems/3sum/}
 * @link {https://www.bilibili.com/video/BV1JL411c7fU}
 * @link {https://www.bilibili.com/video/BV1rb4y1U7BE }
 */
public class 三数之和Test02 {

    public static void main(String[] args) {
        //int[] arr = new int[]{-1, 0, 1, 2, -1, 4};
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = new 三数之和Test02().threeSum(arr);

        for (List<Integer> sum : lists) {
            System.out.println(sum.toString());
        }
    }

    // 双指针
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }

        int[] sortedArr = Arrays.stream(nums).sorted().toArray();

        for (int i = 0; i < sortedArr.length; i++) {
            int num = sortedArr[i];
            int left = i + 1;
            int right = sortedArr.length - 1;

            if (num > 0) {
                continue;
            }

            // 不能少
            if (i > 0 && num == sortedArr[i - 1]) {
                continue;
            }

            while (left < right) {

                int sum = sortedArr[left] + num + sortedArr[right];

                if (sum == 0) {

                    list.add(Arrays.asList(num, sortedArr[left], sortedArr[right]));

                    // 去重
                    while (left < right && sortedArr[left] == sortedArr[left + 1]) {
                        left++;
                    }
                    // 去重
                    while (left < right && sortedArr[right] == sortedArr[right - 1]) {
                        right--;
                    }

                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {// sum <0
                    left++;
                }
            }

        }

        return list;
    }
}
