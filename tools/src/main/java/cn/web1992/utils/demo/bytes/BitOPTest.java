package cn.web1992.utils.demo.bytes;

/**
 * @author web1992
 * @date 2022/6/15  22:56
 */
public class BitOPTest {
    public static void main(String[] args) {
        and(100);
        or(3, 4);
        letMove(1, 2);
    }

    public static void and(int num) {
        // 查询字节码会看到 iand 指令
        // iand 含义
        // iand 将栈顶两 int 型数值作“按位与”并将结果压入栈顶 （注意是int类型）
        int a = num & 0xFF;
        System.out.println(a);
    }

    public static void or(int num, int num2) {
        // 查询字节码会看到 ior 指令
        // ior 含义
        // ior 将栈顶两 int 型数值作“按位或”并将结果压入栈顶
        int a = num | num2;
        System.out.println(a);
    }

    public static void letMove(int num, int bit) {
        // 查询字节码会看到 ishl 指令
        // ishl 含义
        // 将 int 型数值左移指定位数并将结果压入栈顶
        int a = num << bit;
        System.out.println(a);
    }

}
