package cn.web1992.leet.code.containsduplicate;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2020/3/17  23:13
 * @Link {https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/}
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 34, 45, 11, 12, 0, 1, 3, 4, 5, 1};
        int[] arr1 = new int[]{1, 22, 4, 5, 66, 77};

        System.out.println(containsDuplicate2(arr));
        System.out.println(containsDuplicate2(arr1));

    }


    public static boolean containsDuplicate(int[] nums) {


        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {


        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
