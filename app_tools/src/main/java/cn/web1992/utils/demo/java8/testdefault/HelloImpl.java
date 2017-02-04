package cn.web1992.utils.demo.java8.testdefault;

/**
 * @author web1992
 * @deta 2017/2/4
 * @desc 总结三点：
 *      1，default 修饰的方法可以被重写
 *      2，default 只能在接口中使用
 *      3，可以认为是公有（public）的方法，可以被其他类调用
 */
public class HelloImpl implements IHello {

    //这里你可以重写IHello接口中的默认方法

//    @Override
//    public void say() {
//        System.out.println("Hi i am form HelloImpl");
//    }

    public static void main(String[] args) {
        IHello hello = new HelloImpl();
        hello.say();
    }
}

/**
 * EOF
 */