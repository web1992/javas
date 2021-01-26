package cn.web1992.utils.demo.lambda;

/**
 * @author web1992
 * @date 2021/1/26  9:55 上午
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
