package cn.web1992.utils.demo.gc;
/**
 * @link {https://www.cnblogs.com/myseries/p/12884249.html}
 */

/**
 * <pre>
 *     -server -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB -XX:+EliminateAllocations
 * </pre>
 *
 * <pre>
 *
 * -server
 * -Xmx15m
 * -Xms15m
 * -XX:-DoEscapeAnalysis
 * -XX:+PrintGC
 * -XX:-UseTLAB
 * -XX:+EliminateAllocations
 * -Xloggc:/Users/zl/gc-AllotOnStack.log
 * </pre>
 */
public class AllotOnStack {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("blueStarWei");
    }

    static class User {
        Integer id;
        String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}