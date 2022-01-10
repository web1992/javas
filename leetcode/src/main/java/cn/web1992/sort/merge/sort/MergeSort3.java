package cn.web1992.sort.merge.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/1/6  9:17 下午
 */
public class MergeSort3 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 6, 72, 432, 234, 2, 9, -2, 0, -1, -2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        sort0(arr, 0, arr.length - 1);
    }

    public static void sort0(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = (right + left) / 2;

        // 排序
        sort0(arr, left, mid);
        sort0(arr, mid + 1, right);
        // 合并
        merge(arr, left, mid, right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] tmp = new int[arr.length];
        int li = left;
        int ri = mid + 1;
        int ki = left;
        while (li <= mid && ri <= right) {
            if (arr[li] > arr[ri]) {
                tmp[ki++] = arr[ri++];
            } else {
                tmp[ki++] = arr[li++];
            }
        }
        while (li <= mid) {
            tmp[ki++] = arr[li++];
        }

        while (ri <= right) {
            tmp[ki++] = arr[ri++];
        }

        while (left <= right) {
            arr[left] = tmp[left];
            left++;
        }

    }

}
