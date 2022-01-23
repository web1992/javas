package cn.web1992.sort.merge.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/1/6  9:17 下午
 */
public class MergeSort5 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 6, 72, 432, 234, 2, 9, -2, 0, -1, -2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        sort0(arr, 0, arr.length - 1);
    }

    public static void sort0(int[] arr, int left, int right) {


    }

    private static void merge(int[] arr, int left, int mid, int right) {



    }

}
