package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/5/3  15:48
 * @link {https://leetcode-cn.com/problems/longest-palindromic-substring/}
 */
public class 最长回文子串 {


    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int begin = 0;
        int maxLength = 1;

        // babad
        for (int L = 2; L <= len; L++) {

            for (int i = 0; i < len; i++) {
                int j = i + L - 1;
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && maxLength < j - i + 1) {
                    begin = i;
                    maxLength = j - i + 1;
                }
            }


        }

        return s.substring(begin, begin + maxLength);
    }

}
