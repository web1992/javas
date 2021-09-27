package cn.web1992.utils.demo.stacklen;

/**
 * @author erbao.wang
 * @date 2021/8/12  下午8:36
 * -Xss256k
 */
public class StackLenTest {

    private int stackLen = 1;

    public static void main(String[] args) {

        StackLenTest stackLenTest = new StackLenTest();
        try {

            stackLenTest.test();
        } catch (Throwable e) {
            System.out.println("stack len = " + stackLenTest.stackLen);
            throw e;
        }
    }

    public void test() {
        stackLen++;
        int a = 1;
        long b = 123;
        double c = 111111;
        test();
    }
}
