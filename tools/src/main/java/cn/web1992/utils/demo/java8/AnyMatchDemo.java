package cn.web1992.utils.demo.java8;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnyMatchDemo {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("web1992", "java", "java8", "stream", "biu biu biu ...");
        List<String> lengthList = wordList.stream().flatMap(Stream::of).collect(Collectors.toList());
        System.out.println(lengthList);
    }
}
