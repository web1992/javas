package cn.web1992.sort.bubble.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2020/3/5  21:49
 * 冒泡排序
 */
public class BubbleSort2 {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 6, 72, 432, 234, 2, 9, -2, 0, -1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {

        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    // 后移
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

}
