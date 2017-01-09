package cn.web1992.utils.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by web on 2017/1/9.
 */
public class LamabdaFilterDemo {
    public static void main(String[] args) {
        List<String> arrays = Arrays.asList("1", "2", "3", "4");


        Predicate<String> p = (String s) -> s.equals("3");


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
