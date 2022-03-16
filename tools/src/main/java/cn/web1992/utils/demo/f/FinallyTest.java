package cn.web1992.utils.demo.f;

/**
 * @author web1992
 * @date 2022/3/16  5:46 下午
 */
public class FinallyTest {
    public static void main(String[] args) {

        System.out.println(foo());
    }

    private static int foo() {
        try {

            int a = 1 / 0;
            return 1;
        } catch (Exception e) {
            int a = 1 / 0;
            return 2;
        } finally {
            return 3;
        }
    }
}
