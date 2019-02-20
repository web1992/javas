package cn.web1992.utils.demo.thread;


import java.util.HashMap;
import java.util.Map;

public class ThreadLocalDemo {

    private static final ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(HashMap::new);

    @SuppressWarnings("unchecked")
    public static <V> V get(String key) {
        // get
        return (V) threadLocal.get().get(key);
    }

    public static void set(String key, Object v) {
        // clear
        threadLocal.get().clear();
        // put
        threadLocal.get().put(key, v);
    }

    public static void main(String[] args) {

        ThreadLocalDemo.set("id", "123456");
        Object id = ThreadLocalDemo.get("id");
        System.out.println(id);

    }
}
