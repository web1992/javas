package cn.web1992.sort.radix.sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author web1992
 * @date 2022/3/5  10:34 下午
 */
public class RadixSort {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put(null, null);
        map.put(null, "a");
        map.put("", null);

        map = new LinkedHashMap<>();
        map.put(null, null);
        map.put(null, "a");
        map.put("", null);


        Set<String> hasSet = new HashSet<>();

        hasSet.add(null);

    }
}
