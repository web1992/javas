package cn.web1992.leet.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author web1992
 * @date 2022/5/1  14:07
 * @link {https://leetcode-cn.com/problems/two-sum/}
 */
public class 两数之和 {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum(nums, 9)));
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }

        return new int[0];
    }


}
