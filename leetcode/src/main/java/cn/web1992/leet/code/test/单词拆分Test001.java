package cn.web1992.leet.code.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author web1992
 * @date 2022/4/9  14:52
 * @link {https://www.bilibili.com/video/BV1wi4y1X7C9}
 * @link {https://leetcode-cn.com/problems/word-break/}
 */
public class 单词拆分Test001 {

    public static void main(String[] args) {

        //  s = "leetcode", wordDict = ["leet", "code"]

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        System.out.println(wordBreak(s, wordDict));
    }

    // 动态规划
    public static boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        // dp[i]=true的含义：字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && wordDict.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[len];

    }

}
