package cn.web1992.leet.code.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author web1992
 * @date 2022/3/7  9:18 下午
 * @link {https://www.bilibili.com/video/BV1um4y1Z7oE}
 * @link {https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/}
 */
public class 无重复的最大子串Test003 {
    public static void main(String[] args) {

        String str = "abcbbcbb";

        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String str) {

        // map 计数
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            map.merge(ch, 1, Integer::sum);
            while (map.get(ch) > 1) {
                map.merge(str.charAt(left), -1, Integer::sum);
                left++;
            }

            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }

}
