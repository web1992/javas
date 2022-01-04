package cn.web1992.sort.insert.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2021/12/29  3:14 下午
 */
public class InsertSort3 {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 100, 200, 300, 400, 500, 0, 1, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }


    // 核心思路：在已经有序的部分，找到位置，插入
    public static void sort(int[] arr) {

        // 1,2,3,16,5,50
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int val = arr[i];
            for (; j >= 0; j--) {
                if (arr[j] > val) {
                    // 后移
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = val;
        }

    }
}
