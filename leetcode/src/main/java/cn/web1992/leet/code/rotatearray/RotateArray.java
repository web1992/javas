package cn.web1992.leet.code.rotatearray;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2020/2/27  22:51
 * @link {https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/}
 */
public class RotateArray {
    public static void main(String[] args) {

        int[] ints = rotateArray(new int[]{1, 5, 2, 3, 4, 5, 0, 0, 0}, 5);
        // [4, 5, 0, 0, 0, 1, 5, 2, 3]
        System.out.println(Arrays.toString(ints));
    }

    private static int[] rotateArray(int[] arr, int k) {

        if (arr == null) {
            return null;
        }

        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            newArr[(i + k) % arr.length] = arr[i];
        }

        return newArr;

    }
}
