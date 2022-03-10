package cn.web1992.leet.code.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author web1992
 * @date 2022/3/2  10:30 下午
 * @link {https://www.bilibili.com/video/BV1JL411c7fU}
 * link {https://www.bilibili.com/video/BV1rb4y1U7BE}
 */
public class 三数之和Test01 {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, 4};
        for (int[] _arr : sums(arr)) {
            System.out.println(Arrays.toString(_arr));
        }
    }

    // 双指针
    private static List<int[]> sums(int[] arr) {

        List<int[]> ans = new ArrayList<>();
        // [-1, -1, 0, 1, 2, 4]
        int[] arrSorted = Arrays.stream(arr).sorted().toArray();
        int len = arrSorted.length;

        for (int i = 0; i < len; i++) {
            int left = i;
            int right = len - 1;
            while (left < right) {
                int sum = arrSorted[left] + arrSorted[left + 1] + arrSorted[right];
                if (sum == 0) {
                    ans.add(new int[]{arrSorted[left], arrSorted[left + 1], arrSorted[right]});
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
                } else {// sum>0
                    right--;
                }
            }
        }

        return ans;
    }
}
