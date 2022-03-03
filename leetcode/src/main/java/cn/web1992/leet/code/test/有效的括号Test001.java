package cn.web1992.leet.code.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author web1992
 * @date 2022/3/2  10:02 下午
 * @link {https://www.bilibili.com/video/BV13F411b7hs}
 */
public class 有效的括号Test001 {


    public static final Map<String, String> map = new HashMap<>();

    static {
        map.put("]", "[");
        map.put("}", "{");
        map.put(")", "(");
        map.put(">", "<");
    }

    public static void main(String[] args) {

        assert check("[{()[]}{}]");
        assert !check("[]([)");
        assert check("[]()");
        assert check("<{({[<>]})}>");
        assert !check("<{([<>]})}");
    }


    public static boolean check(String str) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            String ch = String.valueOf(str.charAt(i));
            if (!stack.empty() && map.get(ch).equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.empty();
    }
}
