package cn.web1992.leet.code.reverseString;

/**
 * @author web1992
 * @date 2020/3/3  21:34
 * @link {https://leetcode-cn.com/problems/reverse-string/}
 */
public class ReverseString {
    public static void main(String[] args) {

        char[] chars = reverseString("0123456789".toCharArray());

        System.out.println(chars);
    }

    public static char[] reverseString(char[] chars) {

        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }

        return chars;
    }
}
