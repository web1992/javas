package cn.web1992.sort.select.sort;

import java.util.Arrays;

/**
 * SelectSort 选择排序
 *
 * @author web1992
 */
public class SelectSort3 {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 11, 34, 5, 6, 32, 123, 98};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 思路： 找到最小的 index,交换
    private static void selectSort(int[] arr) {

        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int sIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[sIndex]) {
                    sIndex = j;
                }
            }

            if (sIndex != i) {
                int t = arr[i];
                arr[i] = arr[sIndex];
                arr[sIndex] = t;
            }
        }

    }

}
