package cn.web1992.sort.merge.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/1/6  9:17 下午
 */
public class MergeSort2 {

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
        int mid = (left + right) / 2;

        sort0(arr, left, mid);
        sort0(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[arr.length];

        // 两个指针分区指向数组的开始位置
        int li = left, ri = mid + 1, ki = left;

        while (li <= mid && ri <= right) {
            if (arr[li] < arr[ri]) {
                temp[ki++] = arr[li++];
            } else {
                temp[ki++] = arr[ri++];
            }
        }

        while (li <= mid) {
            temp[ki++] = arr[li++];
        }

        while (ri <= right) {
            temp[ki++] = arr[ri++];
        }
        //copy
        while (left <= right) {
            arr[left] = temp[left];
            left++;
        }

    }

}
