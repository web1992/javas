package cn.web1992.leet.code;


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
public class 基本计算器 {

    public static void main(String[] args) {

        String str = "(1+(4+5+2)-3)+(6+8)";
        //int ans = calculate(str);
        //System.out.println("ans=" + ans);

        //str = "2147483647";
        //System.out.println(calculate(str));

        str = "- (3 + (4 + 5))";
        System.out.println(calculate(str));

    }


    public static int calculate(String s) {

        int sum = 0;
        int sign = 1;// 1 =加发，-1=减法
        Stack<Integer> stack = new Stack<>();
        String temp = "";
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
            } else if (ch == ')') {
                Integer preSign = stack.pop();// 符号
                Integer preSum = stack.pop();// sum
                sum = sum * preSign + preSum;
                i++;
            } else if (ch == '(') {
                stack.push(sum);// sum
                stack.push(sign);// 符号
                sum = 0;
                sign = 1;
                i++;
            } else if (ch == '+') {
                sign = 1;
                i++;
            } else if (ch == '-') {
                sign = -1;
                i++;
            } else {
                i++;
                // 数字
                temp = (ch) + "";
                while (i < s.length() && isNum(s.charAt(i))) {
                    temp += s.charAt(i);
                    i++;
                }
                sum += parseNum(temp) * sign;
            }

            // System.out.println(sum);
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
