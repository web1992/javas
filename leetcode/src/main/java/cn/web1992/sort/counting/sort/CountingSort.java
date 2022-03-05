package cn.web1992.sort.counting.sort;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/3/5  10:15 下午
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 100, 200, 300, 400, 500, 0, 1, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int len = arr.length;
        int max = arr[0];

        // 找到最大值
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // 初始化最大数据
        int[] countArr = new int[max + 1];

        // 计数
        for (int i = 0; i < len; i++) {
            countArr[arr[i]]++;
        }

        // 累加
        for (int i = 1; i <= max; i++) {
            countArr[i] = countArr[i - 1] + countArr[i];
        }

        // 核心
        int[] temp = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            // 计算Index
            int index = countArr[arr[i]] - 1;
            // 设置Index处的值
            temp[index] = arr[i];
            // 更新count-1
            countArr[arr[i]]--;
        }

        // copy 复制
        for (int i = 0; i < len; i++) {
            arr[i] = temp[i];
        }

    }

}
