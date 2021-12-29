package cn.web1992.sort.select.sort;

import java.util.Arrays;

/**
 * SelectSort 选择排序
 *
 * @author web1992
 */
public class SelectSort2 {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 11, 34, 5, 6, 32, 123, 98};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void selectSort(int[] arr) {

        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int smallIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[smallIndex]) {
                    smallIndex = j;
                }
            }
            if (smallIndex != i) {
                int t = arr[smallIndex];
                arr[smallIndex] = arr[i];
                arr[i] = t;
            }
        }

    }

}
