package cn.web1992.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/4/18  10:19
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 99, 33, 1, 3, 4, 11, 22, 34, -1};
        sort(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }


    // 冒泡排序（Bubble Sort）
    // 基于比较的排序
    // 会移动元素
    // 需要一个额外的空间（临时变量）
    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean sort = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    sort = false;
                    int t = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = t;
                }
            }
            if (sort) {
                break;
            }
        }
    }

}
