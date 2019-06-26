package cn.web1992.utils.demo.classloader;

public class StaticTest {

    private static int i = 0;

    static {
        j = 0;
        System.out.println(i);
        // Error:(10, 28) java: 非法前向引用
        //System.out.println(j);
    }

    private static int j = 0;

    public static void main(String[] args) {

    }
}
