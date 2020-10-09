package cn.web1992.utils.demo.classloader;

/**
 * @author web1992
 * @date 2020/10/8  16:56
 */
public class ContextClassLoaderTest {

    public static void main(String[] args) {

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        System.out.println(cl);
        System.out.println(cl.getParent());
        System.out.println(cl.getParent().getParent());

        // Expect:
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        // sun.misc.Launcher$ExtClassLoader@372f7a8d
        // null
    }
}
