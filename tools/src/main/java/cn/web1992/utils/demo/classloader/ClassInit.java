package cn.web1992.utils.demo.classloader;

/**
 * @author web1992
 * @date 2020/10/6  22:30
 */
public class ClassInit {


    // 1
    private static int x = 0;
    private static int y;

    // 2
    private static ClassInit classInit = new ClassInit();

    private ClassInit() {
        x = 1;
        y = 1;
    }

    public static ClassInit getInstance() {

        return classInit;
    }

    public static void main(String[] args) {

        ClassInit instance = getInstance();

        System.out.println(instance.x);
        System.out.println(instance.y);
    }
}
