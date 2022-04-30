package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/4/22  14:56
 */
public class 第K小元素 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
        // [-3, -2, -1, 1, 4, 11, 22, 33, 34, 99]
        System.out.println("findK=" + findK(arr, 2));
    }

    // 第K小元素
    public static int findK(int[] arr, int k) {

        int len = arr.length - 1;
        int p = part(arr, 0, len);

        while (p + 1 != k) {
            if (p + 1 < k) {
                p = part(arr, p + 1, len);
            } else {
                p = part(arr, 0, p - 1);
            }
        }
        return arr[p];
    }


    private static int part(int[] arr, int start, int end) {

        int val = arr[end];
        int i = start;
        for (int j = i; j < end; j++) {
            if (arr[j] <= val) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
