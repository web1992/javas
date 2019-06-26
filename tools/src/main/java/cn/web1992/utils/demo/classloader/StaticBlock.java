package cn.web1992.utils.demo.classloader;

/**
 * StaticBlock class static init
 * StaticBlock 1
 * SubClass static init
 * SubClass 1
 * class new init
 * SubClass init
 */
public class StaticBlock {

    static int a = 1;

    static {
        System.out.println("StaticBlock class static init");
        System.out.println("StaticBlock " + a);
        //System.out.println(b);
    }

    static int b = 2;

    {
        System.out.println("class new init");
    }

    public static void main(String[] args) {
        new SubClass();

    }
}

class SubClass extends StaticBlock {
    static {
        System.out.println("SubClass static init");
        System.out.println("SubClass " + a);
    }

    {
        System.out.println("SubClass init");
    }
}
