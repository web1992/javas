package cn.web1992.utils.demo.java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by web1992 on 2016/8/23.
 *
 * @desc
 */
public class MainJava8 {
    public static void main(String[] args) {

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());


        String concat = Stream.of("A", "B", "C", "D").reduce(",", String::concat);

        System.out.println("concat " + concat);
    }
}
