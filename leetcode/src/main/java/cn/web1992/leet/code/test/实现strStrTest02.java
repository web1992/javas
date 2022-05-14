package cn.web1992.leet.code.test;

import java.util.Arrays;

/**
 * @author web1992
 * @date 2022/5/12  20:46
 * @link {https://leetcode.cn/problems/implement-strstr/}
 * @link {https://programmercarl.com/0028.%E5%AE%9E%E7%8E%B0strStr.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC}
 */
public class 实现strStrTest02 {


    public static void main(String[] args) {
        String str = "hello";
        System.out.println("strStr=" + strStr(str, "ll"));

    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }


        int[] next = getNext(needle);
        //System.out.println(Arrays.toString(next));

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {

            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return (i - needle.length() + 1);
            }


        }

        return -1;
    }

    // aabbccf
    // aaabbbcccf
    // aaaabbbbccccf
    public static int[] getNext(String str) {

        int[] next = new int[str.length()];
        int j = 0;
        next[0] = j;

        for (int i = 1; i < str.length(); i++) {

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }

            next[i] = j;
        }

        return next;
    }

}
