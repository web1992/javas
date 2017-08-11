package cn.web1992.utils.demo.pointer;

/**
 * @author web1992
 * @date 2017/8/2 16:47
 * @desc
 */
public class PointerDemo {


    public static void main(String[] args){

        A a1 = new A();
        A a2 = null;

        a1.name="A";
        System.out.println(a1.name);
        a2= a1;
        System.out.println(a2.name);
        a1.name="B";
        System.out.println(a2.name);
        System.out.println(a1.name);



        int x=1;
        int y=2;
        y=1;
        x=3;

        System.out.println(x);

        System.out.println(y);

        x=4;

        System.out.println(x);
        System.out.println(y);

    }


    static class A{

        public String name;
    }

}

