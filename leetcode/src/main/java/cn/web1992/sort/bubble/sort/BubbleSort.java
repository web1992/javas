package cn.web1992.sort.bubble.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2020/3/5  21:49
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] sort = sort(new int[]{1, 5, 6, 72, 432, 234, 002, 9, -2, 0, -1});
        System.out.println(Arrays.toString(sort));
    }

    private static int[] sort(int[] sourceArray) {

        for (int i = 0; i < sourceArray.length - 1; i++) {

            for (int j = 0; j < sourceArray.length - 1; j++) {

                if (sourceArray[j] > sourceArray[j + 1]) {
                    int temp = sourceArray[j + 1];
                    // 后移
                    sourceArray[j + 1] = sourceArray[j];
                    sourceArray[j] = temp;
                }

            }
        }

        return sourceArray;
    }

}
