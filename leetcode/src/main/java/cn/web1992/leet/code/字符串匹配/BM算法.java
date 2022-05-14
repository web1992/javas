package cn.web1992.leet.code.字符串匹配;

/**
 * @author web1992
 * @date 2022/4/30  16:17
 * @implNote BM算法 Boyer-Moore
 */
public class BM算法 {

    public static void main(String[] args) {

        String str = "a";
        System.out.println("strStr=" + strStr(str, "a"));
        System.out.println("strStr=" + new Solution().strStr(str, "a"));

    }

    public static int strStr(String haystack, String needle) {

        int mLen = needle.length();
        if (mLen == 0) {
            return 0;
        }

        if (mLen > haystack.length()) {
            return -1;
        }


        // hello
        // ll
        for (int i = 0; i + mLen <= haystack.length(); i++) {

            boolean f = true;
            for (int j = 0; j < mLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    f = false;
                    break;
                }
            }
            if(f){
                return i;
            }
        }


        return -1;
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            int n = haystack.length(), m = needle.length();
            for (int i = 0; i + m <= n; i++) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
            return -1;
        }
    }

}
