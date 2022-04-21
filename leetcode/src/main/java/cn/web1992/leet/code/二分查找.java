package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/4/21  09:26
 */
public class 二分查找 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -1, 1, 3, 4, 11, 22, 33, 34, 99};

        int num = find(arr, -2);

        System.out.println("num=" + num);
        System.out.println("num=" + find(arr, 99));
        System.out.println("num=" + find(arr, 34));
    }

    public static int find(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int m = (left + right) / 2;
            if (arr[m] < num) {
                left = m + 1;
            } else if (arr[m] > num) {
                right = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
