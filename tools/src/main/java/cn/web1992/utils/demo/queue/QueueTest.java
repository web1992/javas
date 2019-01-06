package cn.web1992.utils.demo.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.BiConsumer;

import static java.util.stream.Collectors.joining;

public class QueueTest {
    public static void main(String[] args) throws InterruptedException {

        int size = 10;
        List<String> list=new ArrayList<>();


        for (int i = 0; i < size ; i++) {
            list.add(""+i);
        }



        list.sort(String::compareToIgnoreCase);

        String lambad="lambad";
        // a = str1.compareToIgnoreCase(str1)
        // int -> (b,c)
        // 符合这样的方法签名
        int a = lambad.compareToIgnoreCase(lambad);


        String collect = list.stream().collect(joining());
        System.out.println(collect);

        Comparator<String> stringComparator = (String c, String b) -> c.compareToIgnoreCase(b);
    }
}
