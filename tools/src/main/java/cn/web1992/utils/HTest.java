package cn.web1992.utils;

public class HTest {

    // 在 B 实例化的时候，实例化 A 并把 A 当作构造参数 传入 B 中
    // 再调用的时候，可以同时执行 A，B两个类的方法
    // 如果 ChannelHandler 中有多个方法，那么 A B 可以实现，覆盖 不同的方法
    // 起到不同的作用
    public static void main(String[] args) {

        new B(new A()).say();
        // A#say ...
        // B#say ...
    }
}

interface ChannelHandler {
    void say();
}

class A implements ChannelHandler {

    public void say() {
        System.out.println("A#say ...");
    }

}

class B implements ChannelHandler {

    private ChannelHandler chanelHandler;

    public B(ChannelHandler chanelHandler) {
        this.chanelHandler = chanelHandler;
    }

    public void say() {
        chanelHandler.say();
        System.out.println("B#say ...");
    }
}