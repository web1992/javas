package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/5/8  20:49
 * @link {https://leetcode-cn.com/problems/reverse-string-ii/}
 */
public class 反转字符串2 {

    /**
     * Input: s = "abcdefg", k = 2
     * Output: "bacdfeg"
     *
     * @param args
     */
    public static void main(String[] args) {

        String s = "abcdefg";

        String ans = reverseStr2(s, 2);

        System.out.println("ans=" + ans);
    }


    public static String reverseStr(String s, int k) {

        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            //用异或运算反转
            while (start < end) {
                char t = ch[start];
                ch[start] = ch[end];
                ch[end] = t;
                start++;
                end--;
            }
        }
        return new String(ch);
    }

    public static String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();

        // abcdefg
        for (int start = 0; start < s.length(); start += (2 * k)) {
            int end = Math.min(s.length() - 1, start + k - 1);
            reverseStr0(chars, start, end);
        }

        return new String(chars);

    }

    public static void reverseStr0(char[] chars, int start, int end) {

        while (start <= end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }

    }



}
