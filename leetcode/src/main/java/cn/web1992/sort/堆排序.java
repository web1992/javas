package cn.web1992.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/4/18  10:21
 */
public class 堆排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 10, 3, 5, 1, 2};
        sort(arr);
        // heapify(arr, arr.length, 0);
        //buildHeap(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        sort0(arr);
    }

    public static void sort0(int[] arr) {
        buildHeap(arr);

        for (int j = arr.length - 1; j >= 0; j--) {
            swap(arr, j, 0);
            heapify(arr, j, 0);
        }

    }

    /**
     * @param arr
     * @param len 数组长度
     * @param i   从哪个元素开始 堆化
     * @implNote 数组 堆化
     */
    public static void heapify(int[] arr, int len, int i) {

        if (i >= len) {
            return;
        }

        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;

        if (c1 < len && arr[max] < arr[c1]) {
            max = c1;
        }

        if (c2 < len && arr[max] < arr[c2]) {
            max = c2;
        }

        if (max != i) {
            swap(arr, max, i);
            heapify(arr, len, max);
        }

    }


    public static void buildHeap(int[] arr) {

        int len = arr.length;

        int lastNode = len - 1;
        int parent = (lastNode - 1) / 2;

        for (int i = parent; i >= 0; i--) {
            heapify(arr, len, i);
        }

    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
