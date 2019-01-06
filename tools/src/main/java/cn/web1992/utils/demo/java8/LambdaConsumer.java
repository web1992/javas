package cn.web1992.utils.demo.java8;

import java.util.function.Consumer;

/**
 * @author web1992
 * @date 2017/2/15 15:35
 * @desc
 */
public class LambdaConsumer {

    public static void main(String[] args) {

        Consumer<String> consumer = (String s) -> System.out.println(s);
        Consumer<String> consumer2 = (String s) -> System.out.println("then " + s);

        consumer.andThen(consumer2).accept("run ");


    }
}

