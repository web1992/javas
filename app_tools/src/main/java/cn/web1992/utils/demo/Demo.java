package cn.web1992.utils.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by web1992 on 2016/8/18.
 *
 * @desc
 */
public class Demo {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("A", "b", "c", "D", "1", "e", "f");

        List<String> collect = stringList.stream()
                .sorted()
                .map(String::toUpperCase)
                .filter(item -> {
                    System.out.println("filter1 " + item);
                    return true;
                })
                .map(s -> s.toLowerCase())
                .filter(item -> {
                    System.out.println("filter2 " + item);
                    return true;
                }).collect(Collectors.toList());


        collect.stream()
                .forEach(item -> {
                    System.out.println("forEach " + item);
                });
    }
}
