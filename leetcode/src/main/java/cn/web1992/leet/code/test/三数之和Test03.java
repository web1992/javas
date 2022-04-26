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
public class 三数之和Test03 {

    public static void main(String[] args) {
        //int[] arr = new int[]{-1, 0, 1, 2, -1, 4};
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = new 三数之和Test03().threeSum(arr);

        for (List<Integer> sum : lists) {
            System.out.println(sum.toString());
        }
    }

    // 双指针
    public List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> list = new ArrayList<>();
        if (arr.length < 3) {
            return list;
        }
        // 排序
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {

            int right = arr.length - 1;
            int num_i = arr[i];
            int left = i + 1;

            if (num_i > 0) {
                continue;
            }
            if (i > 0 && arr[i - 1] == num_i) {
                continue;
            }

            while (left < right) {

                int sum = num_i + arr[left] + arr[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    list.add(Arrays.asList(arr[left], num_i, arr[right]));

                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }

                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }

                    right--;
                    left++;

                }
            }
        }


        return list;
    }
}
