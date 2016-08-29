package cn.web1992.utils.demo.warrape;

/**
 * Created by web1992 on 2016/8/25.
 *
 * @desc  适配器模式
 *
 *  解决类或者接口的 兼容性问题，通过注入，或者
 *  适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题。
 *  主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式。
 *
 *  @blog http://zz563143188.iteye.com/blog/1847029
 *
 *
 */
public interface Sourceable {
    public void m1();
    public void m2();




}


abstract class Warrape implements Sourceable{
    @Override
    public void m1() {
    }

    @Override
    public void m2() {

    }
}



class w1 extends Warrape{
    @Override
    public void m1() {
        System.out.println("i am m1");
    }
}

class w2 extends  Warrape{
    @Override
    public void m2() {
        System.out.println("i am m2");
    }
}