package cn.web1992.data.struct.stack;

/**
 * @author web1992
 * @date 2022/1/25  11:07 上午
 */
public class StackTest {


    public static void main(String[] args) {

        Stack<String> stack = new ArrayStack<>(10);

        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}
