package cn.web1992.sort.merge.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2021/12/31  9:15 上午
 */
public class MergeSort1 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 6, 72, 432, 234, 2, 9, -2, 0, -1, -2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 归并排序
    // 归并排序的核心思想：如果要排序一个数组，我们先把数组从中间分成前后两部分，
    // 然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
    private static void sort(int[] arr) {
        sort0(arr, 0, arr.length - 1);
    }

    private static void sort0(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;

        sort0(arr, start, middle);
        sort0(arr, middle + 1, end);
        merge(arr, start, middle, end);
    }

    // 1. 初始化临时数组
    // 2. 初始化数组指针
    // 3. 对比
    // 4. 处理多余的数据
    // 5. 复制
    // [5,4,3,2,1]
    //
    private static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[arr.length];

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

        while (left <= right) {
            arr[left] = temp[left];
            left++;
        }

    }

}
