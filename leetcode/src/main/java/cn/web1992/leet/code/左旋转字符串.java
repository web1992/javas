package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/5/12  20:35
 * @link {https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/}
 * @link {https://programmercarl.com/%E5%89%91%E6%8C%87Offer58-II.%E5%B7%A6%E6%97%8B%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC}
 */
public class 左旋转字符串 {

    public static void main(String[] args) {

        String str = reverseLeftWords("abcdefg", 2);

        System.out.println("str=" + str);
    }


    public static String reverseLeftWords(String s, int n) {

        char[] chars = s.toCharArray();

        reverse(chars, 0, n - 1);
        reverse(chars, n, s.length() - 1);
        reverse(chars, 0, s.length() - 1);

        return new String(chars);
    }


    public static void reverse(char[] chars, int start, int end) {

        while (start < end) {
            char ch = chars[start];
            chars[start] = chars[end];
            chars[end] = ch;
            start++;
            end--;
        }
    }

}
