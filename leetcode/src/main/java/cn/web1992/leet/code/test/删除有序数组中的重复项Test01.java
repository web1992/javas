package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @date 2022/5/6  10:22
 * @link {https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/}
 */
public class 删除有序数组中的重复项Test01 {

    public static void main(String[] args) {

        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(arr);
        System.out.println("i=" + i);
    }

    public static int removeDuplicates(int[] nums) {

        int newLen = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[newLen++] = nums[i];
            }
        }

        return newLen;
    }


}
