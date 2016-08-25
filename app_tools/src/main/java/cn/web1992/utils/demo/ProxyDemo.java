package cn.web1992.utils.demo;

/**
 * Created by web1992 on 2016/8/25.
 *
 * @desc  类的代理模式
 *  对原来已经有的类，进行包装，可以在原有的方法前，或者方法后，进行某些处理
 *
 */
public class ProxyDemo {
    public static void main(String[] args) {


        SourceI sourceI = new Proxy();// proxy

        sourceI.method();

    }

}

interface SourceI {
    public void method();
}

class Source implements SourceI {
    @Override
    public void method() {
        System.out.println("method");
    }
}


class Proxy implements SourceI {


    public Proxy(){
        this.source = new Source();
    }

    private SourceI source;

    @Override
    public void method() {

        before();
        source.method();
        after();
    }


    private void before() {
        System.out.println("before");
    }


    private void after() {
        System.out.println("after");
    }
}