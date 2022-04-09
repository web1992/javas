package cn.web1992.leet.code;

import java.util.Stack;

/**
 * @author web1992
 * @date 2022/4/9  17:46
 * @link {https://leetcode-cn.com/problems/remove-k-digits/}
 * @link {https://www.bilibili.com/video/BV1yy4y147cY}
 */
public class 移掉K位数字 {

    public static void main(String[] args) {
        System.out.println(new 移掉K位数字().removeKdigits("112", 1));
    }

    // 1432219 , k=3
    public String removeKdigits(String num, int k) {

        char[] chars = num.toCharArray();

        if (k == num.length()) {
            return "0";
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            int n = Integer.parseInt(chars[i] + "");
            while (!stack.empty() && k > 0 && stack.peek() > n) {
                k--;
                stack.pop();
            }
            stack.push(n);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        while (!stack.empty() && stack.elementAt(0) == 0) {
            stack.remove(0);
        }

        if (stack.empty()) {
            return "0";
        }

        String rs = "";
        for (Integer integer : stack) {
            rs += integer;
        }
        return rs;

    }
}
