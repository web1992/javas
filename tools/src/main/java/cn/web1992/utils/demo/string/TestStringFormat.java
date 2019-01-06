package cn.web1992.utils.demo.string;

import cn.web1992.utils.srtutils.StringFormatUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by web1992 on 2016/7/29.
 *
 * @desc
 */
public class TestStringFormat {
    public static void main(String args[]) {

        System.out.println(StringFormatUtil.format("{%s},{%s}", "a", "b"));

        List<Integer> list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(o -> System.out.println(o));
        System.out.println("===");
        list.stream().filter(o -> Integer.valueOf(o) == 1).forEach(o -> System.out.print(o));

        list.stream().filter(o -> Integer.valueOf(o) == 1).forEach(System.out::println);

        list.stream().filter(o -> Integer.valueOf(o) == 1).forEach(System.out::println);

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

    }

}
