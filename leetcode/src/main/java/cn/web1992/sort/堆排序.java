package cn.web1992.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/4/18  10:21
 * @link {https://www.bilibili.com/video/BV1Eb41147dK}
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
        // 构造堆
        buildHeap(arr);
        // 把最【后一个元素】与【第一个元素】进行交换，然后继续进行 堆化 操作
        // 从后往前进行 堆化 操作
        for (int j = arr.length - 1; j >= 0; j--) {
            swap(arr, j, 0);
            heapify(arr, j, 0);
        }

    }

    /**
     * @param arr         数组
     * @param len         数组长度
     * @param parentIndex 从哪个元素开始 堆化
     * @implNote 数组 堆化
     */
    public static void heapify(int[] arr, int len, int parentIndex) {

        if (parentIndex >= len) {
            return;
        }

        int c1 = 2 * parentIndex + 1;
        int c2 = 2 * parentIndex + 2;
        int max = parentIndex;

        if (c1 < len && arr[max] < arr[c1]) {
            max = c1;
        }

        if (c2 < len && arr[max] < arr[c2]) {
            max = c2;
        }

        if (max != parentIndex) {
            swap(arr, max, parentIndex);
            heapify(arr, len, max);
        }

    }


    public static void buildHeap(int[] arr) {

        int len = arr.length;

        // 从下往上进行堆的构造
        int lastNode = len - 1;
        // 找打最后一个parent
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
