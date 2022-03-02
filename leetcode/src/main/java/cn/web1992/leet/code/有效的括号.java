package cn.web1992.leet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author web1992
 * @date 2022/3/2  10:02 下午
 */
public class 有效的括号 {


    public static final Map<String, String> map = new HashMap<>();

    static {
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");
    }

    public static void main(String[] args) {

        System.out.println(check("[{()[]}{}]"));
        System.out.println(check("[]([)"));
        System.out.println(check("[]()"));
    }


    public static boolean check(String str) {

//        if (str.length() % 2 != 0) {
//            return false;
//        }

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            String t = String.valueOf(str.charAt(i));

            if (map.get(t) != null && map.get(t).equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(t);
            }

        }

        System.out.println("is empty " + stack.empty() + " =" + stack.toString());
        return stack.empty();
    }
}
