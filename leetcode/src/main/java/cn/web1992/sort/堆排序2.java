package cn.web1992.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/4/18  10:21
 * @link {https://www.bilibili.com/video/BV1Eb41147dK}
 * <pre>
 *  堆的应用：优先级队列、求 Top K 和求中位数。
 * </pre>
 */
public class 堆排序2 {

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
            swap(arr, j, 0);// 默认是最大堆，下标=0的位置，是最大的元素，这里进行交换，然后继续 堆化
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

        int c1 = 2 * parentIndex;
        int c2 = 2 * parentIndex + 1;
        int max = parentIndex;

        if (c1 < len && arr[c1] > arr[max]) {
            max = c1;
        }
        if (c2 < len && arr[c2] > arr[max]) {
            max = c2;
        }

        if (parentIndex != max) {
            swap(arr, max, parentIndex);
            heapify(arr, len, max);
        }
    }


    public static void buildHeap(int[] arr) {

        int lastIndex = arr.length - 1;
        int parentIndex = (lastIndex - 1) / 2;

        for (int i = parentIndex; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }

    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
