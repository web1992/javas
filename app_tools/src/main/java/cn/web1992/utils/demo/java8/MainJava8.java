package cn.web1992.utils.demo.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
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


        System.out.println("================");
        System.out.println(String.join(":", "foobar", "foo", "bar"));

        String resultChars="foobar:foo:bar"
                .chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .sorted()
                .collect(Collectors.joining());

        System.out.println("resultChars="+resultChars);


        Pattern pattern=Pattern.compile("\\.*@*");

        String[] array={"A@qq.com","B@gmail.com","C@foxmail.com"};

        long count=Stream.of(array).filter(pattern.asPredicate()).count();
        boolean anyMatch=Stream.of(array).anyMatch(pattern.asPredicate());

        System.out.println("count="+count);
        System.out.println("anyMatch="+anyMatch);


//        try {
//            Math.addExact(Integer.MAX_VALUE, 1);
//        }
//        catch (ArithmeticException e) {
//            e.printStackTrace();
//            System.err.println(e.getMessage());
//            // => integer overflow
//        }


        try (Stream<Path> stream = Files.list(Paths.get(""))) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("\n "));
            System.out.println("List: " + joined);

        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
