package cn.web1992.utils.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Created by web on 2017/1/9.
 */
public class LambdaFilterDemo {
    public static void main(String[] args) {
        List<String> arrays = Arrays.asList("1", "2", "3", "4");


        Predicate<String> p = (String s) -> "3".equals(s);


        filter(arrays, p);

    }

    public static void filter(List<String> list, Predicate<String> p) {
        for (String _s : list) {
            if (p.test(_s)) {
                System.out.println(_s);
            }
        }
    }
}
