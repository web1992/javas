package cn.web1992.leet.code.test;

import java.util.Stack;

/**
 * @author web1992
 * @date 2022/4/9  17:46
 * @link {https://leetcode-cn.com/problems/remove-k-digits/}
 * @link {https://www.bilibili.com/video/BV1yy4y147cY}
 */
public class 移掉K位数字Test01 {

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 2));
    }

    // 1432219 , k=3
    public static String removeKdigits(String num, int k) {

        String rs = "";

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            Integer n = Integer.valueOf(num.charAt(i) + "");
            while (!stack.empty() && k > 0 && stack.peek() > n) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        while (k-- > 0) {
            stack.pop();
        }

        while (!stack.empty() && stack.elementAt(0) == 0) {
            stack.remove(0);
        }
        if (stack.empty()) {
            return "0";
        }

        for (Integer integer : stack) {
            rs += integer;
        }
        return stack.toString();

    }
}
