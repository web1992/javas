package cn.web1992.leet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author web1992
 * @implNote 最小覆盖子串
 * @link {https://www.bilibili.com/video/BV1ja41117rS}
 * @date 2022/2/25  9:29 下午
 */
public class 最小覆盖子串 {
    public static void main(String[] args) {
        String target = "ABC";
        String searchTxt = "ADOBECODEBANC";

        String search = search(searchTxt, target);
        System.out.println(search);
        assert "BANC".equalsIgnoreCase(search);
    }


    private static String search(String maxStr, String minStr) {

        // 使用Map存储，字符对应的个数
        // key=字符，value=字符的个数
        Map<Character, Integer> minMap = new HashMap<>();
        Map<Character, Integer> maxMap = new HashMap<>();

        // ABC => minMap = {A=1, B=1, C=1}
        for (int i = 0; i < minStr.length(); i++) {
            minMap.merge(minStr.charAt(i), 1, Integer::sum);
        }

        int left = 0;
        int right = -1;
        int min = Integer.MAX_VALUE;
        int mRight = right;
        int mLeft = left;

        while (right < maxStr.length() - 1) {
            right++;
            char ch = maxStr.charAt(right);
            if (minMap.containsKey(ch)) {
                maxMap.merge(ch, 1, Integer::sum);
            }

            // 检查是否匹配，如果匹配，更新mLeft和mRight
            // 然后再修改left指针，尝试匹配最小的子串
            while (check(minMap, maxMap)) {
                int m = right - left;
                if (m < min) {
                    min = m;
                    mLeft = left;
                    mRight = right;
                }

                // 后面需要修改left,那么就需要更新maxMap里面的数值
                if (minMap.get(maxStr.charAt(left)) != null) {
                    maxMap.merge(maxStr.charAt(left), -1, Integer::sum);
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
