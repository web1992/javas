package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/5/3  16:37
 * @link {https://leetcode-cn.com/problems/remove-element/}
 */
public class 移除元素 {
    public static void main(String[] args) {

    }

    /**
     * <pre>
     *     输入：nums = [3,2,2,3], val = 3
     *     输出：2, nums = [2,2]
     * </pre>
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {

        int slowIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[slowIndex++] = nums[i];
            }
        }

        return slowIndex;
    }


}
