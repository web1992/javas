package cn.web1992.utils.demo.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * desc: LinkedHashMap
 * <p>
 * Version		1.0.0
 *
 * @author web1992
 * <p>
 * Date	      2019/2/11 16:19
 *
 * <pre>
 *     {a=a1, b=b1, c=c1}
 *     a1
 *     {b=b1, c=c1, a=a1}
 * </pre>
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>(10, 0.75f, true);

        map.put("a", "a1");
        map.put("b", "b1");
        map.put("c", "c1");

        System.out.println(map);
        System.out.println(map.get("a"));
        System.out.println(map);
    }
}
