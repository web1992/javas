package cn.web1992.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/4/18  10:20
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 99, 33, 1, 3, 4, 11, 22, 34, -1};
        sort(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }


    // quick sort
    public static void sort(int[] arr) {
        sort0(arr, 0, arr.length - 1);
    }

    public static void sort0(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int p = part(arr, start, end);
        sort0(arr, start, p - 1);
        sort0(arr, p + 1, end);
    }

    public static int part(int[] arr, int start, int end) {

        int p = start + 1;
        int i = p;

        for (; i <= end; i++) {
            if (arr[i] < arr[start]) {
                swap(arr, i, p);
                p++;
            }
        }
        swap(arr, start, p - 1);
        return p - 1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
