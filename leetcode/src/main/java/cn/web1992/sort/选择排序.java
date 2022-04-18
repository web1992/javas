package cn.web1992.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/4/18  10:20
 */
public class 选择排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 99, 33, 1, 3, 4, 11, 22, 34, -1};
        sort(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }


    // 选择排序（Selection Sort）
    public static void sort(int[] arr) {


        for (int i = 0; i < arr.length - 1; i++) {

            int j = i + 1;
            int smIndex = i;
            for (; j < arr.length; j++) {
                if (arr[smIndex] > arr[j]) {
                    smIndex = j;
                }
            }

            if (smIndex != i) {
                int t = arr[smIndex];
                arr[smIndex] = arr[i];
                arr[i] = t;

            }
        }


    }

}
