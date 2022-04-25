package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/4/25  15:30
 */
public class 反转字符串 {
    public static void main(String[] args) {

        char[] str = "hello world!".toCharArray();
        reverseString(str);
        System.out.println("rs= " + new String(str));

    }

    public static void reverseString(char[] ch) {

        if (ch.length <= 1) {
            return;
        }

        int left = 0;
        int right = ch.length - 1;


        while (left <= right) {
            char tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;

            left++;
            right--;
        }

    }
}
