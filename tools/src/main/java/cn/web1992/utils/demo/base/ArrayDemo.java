package cn.web1992.utils.demo.base;


import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("1");
        System.out.println("main " + list);
        func(list);
        System.out.println("main " + list);
    }

    private static void func(List<String> list) {
        list.add("3");
        list = new ArrayList<>();
        list.add("2");
        list.add("4");
        System.out.println("func " + list);
    }
}
