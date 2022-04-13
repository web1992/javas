package cn.web1992.leet.code.test;


import java.util.Stack;

/**
 * @author web1992
 * @date 2022/3/15  9:53 下午
 * @link {https://www.bilibili.com/video/BV16Z4y1k7aM}
 * @link {https://leetcode-cn.com/problems/basic-calculator/}
 * <pre>
 *     输入：(1+(4+5+2)-3)+(6+8)
 *     结果：= 23
 * </pre>
 */
public class 基本计算器Test001 {

    public static void main(String[] args) {

        String str = "(1+(4+5+2)-3)+(6+8)";
        int ans = calculate(str);
        System.out.println("ans=" + ans);

        str = "2147483647";
        System.out.println(calculate(str));

        str = "- (3 + (4 + 5))";
        System.out.println(calculate(str));

    }


    // 0+00 (1+(4+5+2)-3)+(6+8)
    public static int calculate(String s) {

        int sum = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                stack.push(sign);
                stack.push(sum);
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                int preSum = stack.pop();
                int preSign = stack.pop();
                sum = sum * preSign + preSum;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else {
                String temp = "";
                while (i < s.length() && isNum(ch = s.charAt(i))) {
                    temp += ch;
                    i++;
                }
                i--;
                sum = sum + parseNum(temp) * sign;
            }
        }

        return sum;
    }

    private static int parseNum(String ch) {
        return Integer.parseInt(ch);
    }

    private static boolean isNum(char ch) {
        try {
            Integer.parseInt(ch + "");
            return true;
        } catch (NumberFormatException e) {
            // ignore
            return false;
        }
    }
}
