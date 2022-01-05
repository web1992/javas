package cn.web1992.utils.demo.lambda;

/**
 * @author web1992
 * @date 2021/1/26  9:55 上午
 * 输出动态生成的类 -Djdk.internal.lambda.dumpProxyClasses=.
 * <pre>
 *
 * package cn.web1992.utils.demo.lambda;
 *
 * import java.lang.invoke.LambdaForm.Hidden;
 *
 * // $FF: synthetic class
 * final class LambdaTest$$Lambda$1 implements Runnable {
 *     private final LambdaTest arg$1;
 *
 *     private LambdaTest$$Lambda$1(LambdaTest var1) {
 *         this.arg$1 = var1;
 *     }
 *
 *     private static Runnable get$Lambda(LambdaTest var0) {
 *         return new LambdaTest$$Lambda$1(var0);
 *     }
 *
 *     @Hidden
 *     public void run() {
 *         LambdaTest.lambda$main$0(this.arg$1);
 *     }
 * }
 * </pre>
 */
public class LambdaTest {

    public static void main(String[] args) {

        LambdaTest lambdaTest = new LambdaTest();

        Runnable r = () -> {
            lambdaTest.say();
            System.out.println("run");
        };
        System.out.println("r class " + r.getClass().getName());
        r.run();

    }


    private void say() {
        System.out.println("Hi");

    }

}
