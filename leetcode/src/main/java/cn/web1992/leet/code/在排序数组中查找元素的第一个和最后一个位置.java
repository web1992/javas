package cn.web1992.leet.code;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/4/29  14:17
 * @link {https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/}
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {

        int[] arr = new int[]{5, 7, 7, 8, 8, 10};

        System.out.println("ans=" + Arrays.toString(searchRange(new int[]{1, 1, 2}, 1)));
    }


    /**
     * <pre>
     *      输入：nums = [5,7,7,8,8,10], target = 8
     *      输出：[3,4]
     * </pre>
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        int left = 0;
        int right = len - 1;

        int start = -1;
        int end = -1;

        if (len == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }

        while (left <= right) {
            int min = (left + right) / 2;

            if (nums[min] == target) {
                start = min;
                end = min;
                while (end + 1 < len && nums[end + 1] == target) {
                    end++;
                }
                while (start - 1 >= 0 && nums[start - 1] == target) {
                    start--;
                }
                break;
            } else if (nums[min] < target) { // 1,2,3,4,5 t=4
                left = min + 1;
            } else {
                right = min - 1;//  1,2,3,4,5 t=1
            }
        }
        return new int[]{start, end};
    }
}
