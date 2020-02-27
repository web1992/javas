package cn.web1992.utils.demo.classloader.subandsuper;

/**
 * @author web1992
 * @date 2020/2/27  20:14
 */
public class Sub extends Super {
    static {
        System.out.println("Sub init");
    }
}
