package cn.web1992.utils.demo.hashmap;

import java.util.HashMap;

/**
 * @author web1992
 * @date 2020/3/24  21:57
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("aa", "aa2");


        HashMap<String, String> map2 = new HashMap<>(2);
        map2.put("aa", "aa2");
        map2.put("b", "b");
        map2.put("aa1", "xxx");

        System.out.println(map2.merge("aa1", "null", (k, v) -> k + "-" + v));
        System.out.println(map);
        System.out.println(map2);
    }
}
