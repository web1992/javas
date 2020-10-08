package cn.web1992.utils.demo.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author web1992
 * @date 2020/10/8  14:59
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InstantiationException,
            InvocationTargetException {

        String dir = "/Users/zl/Documents/dev/github/javas/tools/src/main/java/cn/web1992/utils/demo/classloader/class";

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        // ClassLoader cl = null;
        MyClassLoader myClassLoader = new MyClassLoader(cl, dir);
        MyClassLoader myClassLoader2 = new MyClassLoader(cl, dir);

        Class<?> mainTest = myClassLoader.loadClass("MainTest");
        Class<?> mainTest2 = myClassLoader2.loadClass("MainTest");

        System.out.println("mainTest == mainTest2 is " + (mainTest == mainTest2));
        // Expect:
        // mainTest == mainTest2 is false
        Object o = mainTest.newInstance();
        Method main = mainTest.getMethod("main");
        main.invoke(o, null);
        // Expect:
        // Hello world!
    }
}
