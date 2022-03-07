package cn.web1992.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author web1992
 * @date 2022/3/7  9:18 下午
 * @link {https://www.bilibili.com/video/BV1um4y1Z7oE}
 */
public class 无重复的最大子串 {
    public static void main(String[] args) {

        String str = "abcabcbb";

        System.out.println(getMinStr(str));
    }

    private static int getMinStr(String str) {

        Map<Character, Integer> map = new HashMap<>();

        int begin = 0;
        int maxLength = -1;


        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            map.merge(ch, 1, Integer::sum);

            while (map.get(ch) > 1) {
                begin++;
                map.merge(ch, -1, Integer::sum);
            }
            maxLength = Math.max(maxLength, j - begin + 1);
        }


        return maxLength;
    }

}
