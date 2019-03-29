package cn.web1992.utils.demo.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * desc: LinkedHashMap
 * <p>
 * Version		1.0.0
 *
 * @author web1992
 * <p>
 * Date	      2019/2/11 16:19
 * <p>
 * 代码输出：
 * <pre>
 *     {a=a1, b=b1, c=c1}
 *     a1
 *     {b=b1, c=c1, a=a1}
 * </pre>
 */
public class LinkedHashMapTest3 {
    public static void main(String[] args) {

        Map<String, String> myMap = new MaxSizeMap<>();
        add(myMap, "a");
        // 如果执行了 get("a1") 那么a1 最近被使用过，就不会被删除
        // myMap.get("a1");
        add(myMap, "b");
        System.out.println(myMap);
        // {a9=9, b0=0, b1=1, b2=2, b3=3, b4=4, b5=5, b6=6, b7=7, b8=8, b9=9}
        // a1 - a8 是最先放进 map，因此超过 11 条的时候，就被删除了
    }

    private static void add(Map<String, String> mapBooks, String id) {
        IntStream.range(0, 10).forEach(i -> {
            mapBooks.put(id + i, "" + i);
        });
    }

    /**
     * MaxSizeMap 重写了  removeEldestEntry 方法
     * 当 Map 中的数据超过 11 个的时候，就删掉最早的数据
     * <p>
     * 可以和 access order 配合使用，从而实现删除最不常用的数据
     * 如果数据被访问过了，那么数据就会放在最后，而删除的时候是从
     * 链表的头部开始删除的
     *
     * @param <K>
     * @param <V>
     */
    static class MaxSizeMap<K, V> extends LinkedHashMap<K, V> {

        private static final long serialVersionUID = -782643560495986549L;
        private static final int MAX_ENTRIES = 11;

        public MaxSizeMap() {
            this(10, 0.75f, true);
        }

        public MaxSizeMap(int initialCapacity, float loadFactor, boolean accessOrder) {
            super(initialCapacity, loadFactor, accessOrder);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
        }
    }

}
