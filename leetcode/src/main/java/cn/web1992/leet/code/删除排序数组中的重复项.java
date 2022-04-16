package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/4/16  18:56
 * @link {https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/1/array/21/}
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        // 有序的数组
        int[] arr = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 2, 3, 3, 3, 3};
        int count = removeDup(arr);

        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int removeDup(int[] arr) {

        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            }
            arr[count++] = arr[i];
        }

        return count;
    }
}
