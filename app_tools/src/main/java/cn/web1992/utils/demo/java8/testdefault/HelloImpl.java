package cn.web1992.utils.demo.java8.testdefault;

/**
 * @author web1992
 * @deta 2017/2/4
 * @desc
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