package cn.web1992.leet.code.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author web1992
 * @implNote 最小覆盖子串
 * @link {https://www.bilibili.com/video/BV1qX4y1V7EC}
 * @link {https://leetcode-cn.com/problems/minimum-window-substring/}
 * @date 2022/2/25  9:29 下午
 */
public class 最小覆盖子串Test004 {
    public static void main(String[] args) {
        String target = "ab";
        String searchTxt = "bba";

        String search = minWindow(searchTxt, target);
        System.out.println(search);
    }


    public static String minWindow(String maxStr, String minStr) {

        int minLen = minStr.length();
        int maxLen = maxStr.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int start = 0;
        int minWindow = Integer.MAX_VALUE;
        int count = minLen;
        for (int i = 0; i < minLen; i++) {
            map.merge(minStr.charAt(i), 1, Integer::sum);
        }

        while (right < maxLen) {
            char c = maxStr.charAt(right++);
            map.merge(c, -1, Integer::sum);
            if (map.get(c) > 0) {
                count--;
            }

            while (count == 0) {
                if (minWindow > right - left) {
                    minWindow = right - left;
                    start = left;
                }

                c = maxStr.charAt(left++);
                map.merge(c, 1, Integer::sum);
                if (map.get(c) >= 0) {
                    count++;
                }

            }
        }

        return minWindow == Integer.MAX_VALUE ? "" : maxStr.substring(start, start + minWindow);
    }



}
