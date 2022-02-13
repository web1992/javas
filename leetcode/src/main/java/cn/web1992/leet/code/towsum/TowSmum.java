package cn.web1992.leet.code.towsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author web1992
 * @date 2022/2/13  11:10 下午
 */
public class TowSmum {
    public static void main(String[] args) {

        int[] nums = new int[]{11, 2, 3, 43, 5};

        int[] ints = towSum(nums, 5);
        System.out.println(Arrays.toString(ints));


        int[] ints2 = towSum2(nums, 5);
        System.out.println(Arrays.toString(ints2));
    }

    public static int[] towSum(int[] nums, int target) {

        Map map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int t = target - num1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (t == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }


    public static int[] towSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int t = target - num1;
            if (map.containsKey(t)) {
                return new int[]{i, map.get(t)};
            } else {
                map.put(num1, i);
            }
        }

        return null;
    }
}
