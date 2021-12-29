package cn.web1992.sort.insert.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2021/12/29  3:14 下午
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 100, 200, 300, 400, 500, 0, 1, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }


    public static void sort(int[] arr) {

        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int val = arr[i];
            for (; j >= 0; j--) {

                if (arr[j] > val) {
                    // 移动(后移)
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }

            arr[j + 1] = val;
        }

    }
}
