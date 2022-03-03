package cn.web1992.leet.code.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author web1992
 * @implNote 最小覆盖子串
 * @link {https://www.bilibili.com/video/BV1ja41117rS}
 * @date 2022/2/25  9:29 下午
 */
public class 最小覆盖子串Test01 {
    public static void main(String[] args) {
        String target = "ABC";
        String searchTxt = "ADOBECODEBANC";

        String search = search(searchTxt, target);
        System.out.println(search);
        assert "BANC".equalsIgnoreCase(search);
    }


    private static String search(String maxStr, String minStr) {

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = -1;
        int mLeft = 0;
        int mRight = -1;

        Map<Character, Integer> minMap = new HashMap<>();
        Map<Character, Integer> maxMap = new HashMap<>();

        for (int i = 0; i < minStr.length(); i++) {
            minMap.merge(minStr.charAt(i), 1, Integer::sum);
        }

        while (right < maxStr.length() - 1) {
            right++;
            char ch = maxStr.charAt(right);
            if (minMap.containsKey(ch)) {
                maxMap.merge(ch, 1, Integer::sum);
            }

            while (check(minMap, maxMap)) {

                int m = right - left;
                if (m < min) {
                    min = m;
                    mLeft = left;
                    mRight = right;
                }

                char chR = maxStr.charAt(left);
                if (minMap.containsKey(chR)) {
                    maxMap.merge(chR, -1, Integer::sum);
                }
                left++;

            }

        }

        return maxStr.substring(mLeft, mRight + 1);
    }

    private static boolean check(Map<Character, Integer> minMap, Map<Character, Integer> maxMap) {

        Set<Character> keys = minMap.keySet();

        for (Character key : keys) {
            if (!maxMap.containsKey(key) || minMap.get(key) > maxMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}
