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

        MyClassLoader myClassLoader = new MyClassLoader(null, dir);

        Class<?> mainTest = myClassLoader.findClass("MainTest");

        Object o = mainTest.newInstance();
        Method main = mainTest.getMethod("main");
        main.invoke(o, null);
        // Expect:
        // Hello world!
    }
}
