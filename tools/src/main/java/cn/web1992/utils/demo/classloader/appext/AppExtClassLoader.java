package cn.web1992.utils.demo.classloader.appext;

/**
 * @author web1992
 * @date 2020/2/27  21:20
 */
public class AppExtClassLoader {
    public static void main(String[] args) {
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(AppExtClassLoader.class.getClassLoader());
        // sun.misc.Launcher$ExtClassLoader@24d46ca6
        System.out.println(AppExtClassLoader.class.getClassLoader().getParent());
        // null
        System.out.println(AppExtClassLoader.class.getClassLoader().getParent().getParent());

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
    }
}
