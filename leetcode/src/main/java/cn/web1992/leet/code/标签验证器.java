package cn.web1992.leet.code;

import java.util.Stack;

/**
 * @author web1992
 * @date 2022/5/2  23:09
 * @link {https://leetcode-cn.com/problems/tag-validator/}
 */
public class 标签验证器 {

    public static void main(String[] args) {

        System.out.println(isValid("<"));
    }


    // <DIV> 和 </DIV>
    // <![CDATA[<div>]>]]>
    public static boolean isValid(String code) {
        int len = code.length();
        System.out.println("code len=" + len);
        if (len < "<A><A/>".length()) {
            return false;
        }

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < len; i++) {

            if (i > 0 && stack.isEmpty()) {
                return false;
            }
            if (i + 9 < len && code.substring(i, i + 9).equals("<![CDATA[")) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0) {
                    return false;
                }
                i += 2;
            } else if (i + 2 < len && code.substring(i, i + 2).equals("</")) {

                int j = i + 2;
                i = code.indexOf(">", j);
                if (i < 0) {
                    return false;
                }
                String tag = code.substring(j, i);
                if (stack.isEmpty() || !stack.peek().equals(tag)) {
                    return false;
                }
                stack.pop();
            } else if (i + 1 < len && code.substring(i, i + 1).equals("<")) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) {
                    return false;
                }

                for (int k = j; k < i; k++) {
                    if (code.charAt(k) < 'A' || code.charAt(k) > 'Z') {
                        return false;
                    }
                }
                String tag = code.substring(j, i);
                stack.push(tag);
            }
        }

        return stack.isEmpty();
    }
}
