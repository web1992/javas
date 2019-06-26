package cn.web1992.utils.demo.classloader;

/**
 * -XX:+TraceClassLoading
 */
public class StaticWithExtendClass {
    public static void main(String[] args) {
        // 直接引用父类静态变量的时候，不会触发初始化
        System.out.println(SuperClass.value);


        // 通过数组引用的时候，不会触发初始化
        SubClass[] arr = new SubClass[1];
        System.out.println(arr);

        // 引用静态的 final 字段，不会触发初始化
        System.out.println(SubClass.finalValue);

        // 引用资料的静态字段，会触发初始化
        // System.out.println(SubClass.value);
    }

    public static class SuperClass {
        public static int value = 1;
        public final static int finalValue = 3;

        static {
            System.out.println("SuperClass");
        }
    }

    public static class SubClass extends SuperClass {
        public static int value = 2;

        static {
            System.out.println("SubClass");
        }
    }
}
