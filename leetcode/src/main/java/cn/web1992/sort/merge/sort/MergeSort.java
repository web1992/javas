package cn.web1992.sort.merge.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2021/12/31  9:15 上午
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 6, 72, 432, 234, 2, 9, -2, 0, -1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 归并排序
    // 归并排序的核心思想：如果要排序一个数组，我们先把数组从中间分成前后两部分，
    // 然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了。
    private static void sort(int[] sourceArray) {

    }
}
