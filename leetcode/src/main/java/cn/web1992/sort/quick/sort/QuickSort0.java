package cn.web1992.sort.quick.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2020/3/5  22:20
 * 快速排序
 */
public class QuickSort0 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 6, 72, 432, 234, 2, 9, -2, 0, -1, -3, -1};
        sort(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }

    private static int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int start, int end) {

        if (start < end) {
            int p = part(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    //         i
    // start   p
    // [40,    50,   20, 10 ,30]
    private static int part(int[] arr, int start, int end) {

        int p = start + 1;

        for (int i = p; i <= end; i++) {
            if (arr[i] < arr[start]) {
                swap(arr, i, p);
                p++;
            }
        }
        swap(arr, start, p - 1);
//        System.out.println("p=" + (p - 1) + " start=" + start + " end=" + end);
//        System.out.println(Arrays.toString(arr));
//        System.out.println();
        return p - 1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
