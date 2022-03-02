package cn.web1992.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author web1992
 * @date 2022/3/2  10:30 下午
 * @link {https://www.bilibili.com/video/BV1JL411c7fU}
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, 4};

        for (int[] sum : sums(arr)) {
            System.out.println(Arrays.toString(sum));
        }
    }

    private static List<int[]> sums(int[] arr) {

        List<int[]> list = new ArrayList<>();
        int[] arrSorted = Arrays.stream(arr).sorted().toArray();

        for (int i = 0; i < arrSorted.length; i++) {
            int left = i;
            int right = arrSorted.length - 1;
            while (left < right) {
                int m = arrSorted[left + 1];
                int sum = arrSorted[left] + m + arrSorted[right];
                if (sum == 0) {
                    list.add(new int[]{arrSorted[left], arrSorted[right], m});
                    while (left < right && arrSorted[left] == arrSorted[left + 1]) {
                        left++;
                    }

                    while (left < right && arrSorted[right] == arrSorted[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    // sum >0
                    right--;
                }
            }
        }

        return list;
    }
}
