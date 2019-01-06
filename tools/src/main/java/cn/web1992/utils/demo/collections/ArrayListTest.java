package cn.web1992.utils.demo.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for(String i:list){
            System.out.println(i);
            list.remove("3");
        }
    }
}
