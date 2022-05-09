package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/5/8  21:50
 * @link {https://leetcode-cn.com/problems/reverse-words-in-a-string/}
 */
public class 颠倒字符串中的单词 {

    /**
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     *
     * @param args
     */
    public static void main(String[] args) {

        String s = "the sky is blue";

        String ans = reverseWords(s);
        System.out.println("ans=" + ans);
    }


    public static String reverseWords(String s) {

        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (chars[start] == ' ') {
            start++;
        }

        while (chars[end] == ' ') {
            end--;
        }

        reverseWords(chars, start, end);

        StringBuilder sb = new StringBuilder();

        // "  hello  world  "
        int st = start;
        for (int i = start; i < end; ) {
            int c = 0;
            if (chars[i + 1] == ' ') {
                i++;
                c++;
                while (chars[i + 1] == ' ') {
                    c++;
                    i++;
                }
                reverseWords(chars, st, i - c);
                for (int k = st; k <= i - c; k++) {
                    sb.append(chars[k]);
                }
                sb.append(' ');

                i++;
                st = i;
            } else {
                i++;
            }

        }
        reverseWords(chars, st, end);
        for (int i = st; i <= end; i++) {
            sb.append(chars[i]);
        }


        return sb.toString();
    }

    public static void reverseWords(char[] chars, int start, int end) {

        while (start < end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }

    }

}
