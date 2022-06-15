package cn.web1992.utils.demo.bytes;

/**
 * @author web1992
 * @date 2022/6/15  22:56
 */
public class AndTest {
    public static void main(String[] args) {
        and(100);
    }

    public static void and(int num) {
        // 查询字节码会看到 iand 指令
        // iand 含义
        // iand 将栈顶两 int 型数值作“按位与”并将结果压入栈顶 （注意是int类型）
        int a = num & 0xFF;
        System.out.println(a);
    }
}
