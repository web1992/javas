package cn.web1992.utils.demo.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
//        Map<String,String> map=new LinkedHashMap<>(2);
        Map<String, String> map = new HashMap<>(2);

        for (int i = 0; i < 20; i++) {
            map.put("" + i, "v" + i);
        }

        map.forEach((k,v)-> System.out.println(k+"="+v));



    }
}
