

package cn.web1992.utils.demo.base;


import java.util.Map;
import java.util.TreeMap;

public class IntToByte {
    public static void main(String[] args) {


        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(6, 6);
        map.put(7, 7);

        Map.Entry<Integer, Integer> integerIntegerEntry = map.ceilingEntry(4);
        Map.Entry<Integer, Integer> integerIntegerEntry2 = map.ceilingEntry(2);

        System.out.println(integerIntegerEntry);
        System.out.println(integerIntegerEntry2);

        int identityHashCode = System.identityHashCode(map);
        System.out.println(identityHashCode);
        map.put(8, 8);

        identityHashCode = System.identityHashCode(map);
        System.out.println(identityHashCode);

        map = new TreeMap<>();

        identityHashCode = System.identityHashCode(map);
        System.out.println(identityHashCode);
    }
}
