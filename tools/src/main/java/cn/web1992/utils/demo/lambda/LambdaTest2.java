package cn.web1992.utils.demo.lambda;

import java.util.function.Supplier;

/**
 * @author web1992
 * @date 2021/1/26  10:11 上午
 * 输出动态生成的类
 * <pre>
 *     -Djdk.internal.lambda.dumpProxyClasses=.
 * </pre>
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        say(LambdaTest2::new);
    }

    private static void say(Supplier<LambdaTest2> supplier) {
        LambdaTest2 lambdaTest2 = supplier.get();
        lambdaTest2.hello();
    }

    private void hello() {
        System.out.println("Hello");
    }
}
