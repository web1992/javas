package cn.web1992.sort.quick.sort;

import java.util.Arrays;

/**
 * <pre>
 * partition(A, p, r) {
 *  pivot := A[r]
 *      i := p
 *      for j := p to r-1 do {
 *      if A[j] < pivot {
 *          swap A[i] with A[j]
 *          i := i+1
 *          }
 *  }
 *  swap A[i] with A[r]
 *  return i
 * }
 * </pre>
 */
public class QuickSort {

    public static void main(String[] args) {
        int array[] = {32, 12, 7, 78, 23, 45};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    // 1. 找到 p 点
    // 2. 小于p点的，放在右边，大于p点的，放到左边
    //  p........ r
    // [5,4,3,2,1,0]
    public static void quickSort(int array[], int left, int right) {
        if (left >= right) {
            return;
        }
        int li = left;
        int ri = right;
        int key = array[left];
        while (li < ri) {
            while (li < ri && array[ri] > key) {
                ri--;
            }
            array[li] = array[ri];
            //从后往前找到第一个比key小的数与array[li]交换；
            while (li < ri && array[li] < key) {
                li++;
            }
            array[ri] = array[li];
            //从前往后找到第一个比key大的数与array[ri]交换；
        }
        array[li] = key;
        //一趟快排之后已经将key的位置找到。
        quickSort(array, left, li - 1);
        //对key左边的进行排序
        quickSort(array, li + 1, right);
        //对key右边的进行排序
    }
}