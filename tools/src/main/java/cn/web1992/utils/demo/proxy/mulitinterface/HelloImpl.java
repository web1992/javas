package cn.web1992.utils.demo.proxy.mulitinterface;

/**
 * @author web1992
 * @date 2021/6/15  8:50 下午
 */
public class HelloImpl implements Hello, Hello2 {

    @Override
    public String say() {
        System.out.println("say");
        return "hi";
    }
}
