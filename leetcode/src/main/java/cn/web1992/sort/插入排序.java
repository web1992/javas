package cn.web1992.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/4/18  10:20
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 99, 33, 1, 3, 4, 11, 22, 34, -1};
        sort(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }


    // 插入排序（Insertion Sort）
    public static void sort(int[] arr) {


        for (int i = 1; i < arr.length; i++) {

            int j = i - 1;
            int val = arr[i];

            for (; j >= 0; j--) {

                if (arr[j] > val) {
                    arr[j + 1] = arr[j];// 移动
                } else {
                    break;
                }
            }

            // 插入
            arr[j + 1] = val;

        }
    }
}
