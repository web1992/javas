package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/5/12  20:46
 * @link {https://leetcode.cn/problems/implement-strstr/}
 * @link {https://programmercarl.com/0028.%E5%AE%9E%E7%8E%B0strStr.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC}
 */
public class 实现strStr {


    public static void main(String[] args) {
        String str = "aaaabbaaaf";
        System.out.println("strStr=" + strStr(str, "f"));

    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = getNext(needle);

        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }

            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }

            if (j == needle.length() - 1) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }


    // a    a  b   a  a  f
    // [-1][0][-1][0][1][-1]

    // a    a    a  a  bbaaaf
    // [-1] [0] [1] [2]
    public static int[] getNext(String str) {

        int len = str.length();
        char[] chars = str.toCharArray();
        int[] next = new int[len];

        int j = -1;
        next[0] = j;

        for (int i = 1; i < len; i++) {

            while (j >= 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }
            if (chars[i] == chars[j + 1]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
