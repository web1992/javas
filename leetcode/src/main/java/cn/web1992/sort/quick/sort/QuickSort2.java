package cn.web1992.sort.quick.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2021/1/4
 * 快速排序
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 6, 72, 432, 234, 2, 9, -2, 0, -1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        sort0(arr, 0, arr.length - 1);
    }

    // 找到p点，小于p点的放在左边，大于p点的放在右边
    private static void sort0(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = part(arr, left, right);
        sort0(arr, left, p - 1);
        sort0(arr, p + 1, right);

    }

    private static int part(int[] arr, int left, int right) {

        int p = left + 1;
        int i = p;

        for (; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, p);
                p++;
            }
        }
        swap(arr, left, p - 1);
        return p - 1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
