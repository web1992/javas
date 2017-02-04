package cn.web1992.utils.demo.java8.testdefault;

/**
 * @author web1992
 * @deta 2017/2/4
 * @desc
 */
public interface IHello {

    default void say(){
        System.out.println("Hi i am form IHello");
    }
}

/**
 * EOF
 */