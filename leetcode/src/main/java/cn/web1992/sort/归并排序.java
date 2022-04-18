package cn.web1992.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/4/18  10:20
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 99, 33, 1, 3, 4, 11, 22, 34, -1};
        sort(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }


    // merge sort
    // 把数据分成两部分，分别排序，然后再合并
    // 分治的思想
    public static void sort(int[] arr) {
        sort0(arr, 0, arr.length - 1);
    }

    // 分治的思想
    public static void sort0(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        sort0(arr, start, mid);
        sort0(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {

        int[] temp = new int[arr.length];

        int left = start;
        int right = mid + 1;
        int k = left;


        while (left <= mid && right <= end) {
            if (arr[left] > arr[right]) {
                temp[k++] = arr[right++];
            } else {
                temp[k++] = arr[left++];
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        while (right <= end) {
            temp[k++] = arr[right++];
        }

        while (start <= end) {
            arr[start] = temp[start];
            start++;
        }

    }

}
