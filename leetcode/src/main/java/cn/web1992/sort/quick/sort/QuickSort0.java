package cn.web1992.sort.quick.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2020/3/5  22:20
 * 快速排序
 */
public class QuickSort0 {

    public static void main(String[] args) {
        int[] sort = sort(new int[]{1, 5, 6, 72, 432, 234, 2, 9, -2, 0, -1});
        System.out.println(Arrays.toString(sort));
    }

    private static int[] sort(int[] sourceArray) {
        quickSort(sourceArray, 0, sourceArray.length - 1);
        return sourceArray;
    }

    private static void quickSort(int[] arr, int start, int end) {

        if (start < end) {
            int p = part(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }


    private static int part(int[] arr, int start, int end) {

        int p = start;
        int index = p + 1;

        for (int i = index; i <= end; i++) {
            if (arr[i] < arr[p]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, p, index - 1);
        return index - 1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
