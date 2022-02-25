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


    private static String search(String searchTxt, String target) {

        // tMap = {A=1, B=1, C=1}
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        int left = 0;
        int right = -1;
        int min = Integer.MAX_VALUE;
        int mRight = right;
        int mLeft = left;

        for (int i = 0; i < target.length(); i++) {
            tMap.merge(target.charAt(i), 1, Integer::sum);
        }

        while (right < searchTxt.length() - 1) {
            right++;
            char ch = searchTxt.charAt(right);
            if (tMap.containsKey(ch)) {
                sMap.merge(ch, 1, Integer::sum);
            }

            while (check(tMap, sMap)) {
                int m = right - left;
                if (m < min) {
                    min = m;
                    mLeft = left;
                    mRight = right;
                }

                if (tMap.get(searchTxt.charAt(left)) != null) {
                    sMap.merge(searchTxt.charAt(left), -1, Integer::sum);
                }
                left++;
            }

        }

        //System.out.println(mLeft);
        //System.out.println(mRight);
        return searchTxt.substring(mLeft, mRight + 1);
    }

    private static boolean check(Map<Character, Integer> m1, Map<Character, Integer> m2) {

        Set<Character> keys = m1.keySet();

        for (Character key : keys) {
            if (!m2.containsKey(key) || m1.get(key) > m2.get(key)) {
                return false;
            }
        }

        //System.out.println("m1=" + m1);
        //System.out.println("m2=" + m2);
        return true;
    }
}
