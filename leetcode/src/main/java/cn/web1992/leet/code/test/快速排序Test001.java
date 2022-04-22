package cn.web1992.leet.code.test;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/4/18  10:20
 * @implNote 分治思想
 * @link {https://www.bilibili.com/video/BV1WF41187Bp} 视频讲解
 */
public class 快速排序Test001 {

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

        if (start > end) {
            return;
        }

        int p = part(arr, start, end);
        sort0(arr, start, p - 1);
        sort0(arr, p + 1, end);

    }

    // 1. 选择p点
    // 2. 大于p的放右边，小于p的放左边
    // 3. 递归处理
    public static int part(int[] arr, int start, int end) {

        int val = arr[end];
        int i = start;

        for (int j = i; j < end; j++) {
            if (arr[j] < val) {
                swap(arr, j, i);
                i++;
            }
        }
        swap(arr, end, i);
        return i;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
