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
public class 最小覆盖子串Test003 {
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
        Map<Character, Integer> maxMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int start = 0;
        int minWindow = Integer.MAX_VALUE;

        for (int i = 0; i < minLen; i++) {
            map.merge(minStr.charAt(i), 1, Integer::sum);
        }

        while (right < maxLen) {
            char c = maxStr.charAt(right++);
            maxMap.merge(c, 1, Integer::sum);

            while (match(map, maxMap)) {
                if (minWindow > right - left) {
                    minWindow = right - left;
                    start = left;
                }

                c = maxStr.charAt(left++);
                maxMap.merge(c, -1, Integer::sum);

            }
        }

        return minWindow == Integer.MAX_VALUE ? "" : maxStr.substring(start, start + minWindow);
    }

    private static boolean match(Map<Character, Integer> map, Map<Character, Integer> maxMap) {

        for (Character key : map.keySet()) {

            if (!maxMap.containsKey(key) || map.get(key) > maxMap.get(key)) {
                return false;
            }
        }
        return true;
    }

}
