package cn.web1992.utils.demo.proxy.mulitinterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author web1992
 * @date 2021/6/15  8:50 下午
 */
public class HelloMain {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Object o = Proxy.newProxyInstance(HelloMain.class.getClassLoader(), new Class[]{Hello.class, Hello2.class}, new H(new HelloImpl()));
        ((Hello) o).say();
        ((Hello2) o).say();

    }
}

class H implements InvocationHandler {

    private Object target;

    public H(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("invoke run ");
        Object invoke = method.invoke(target, args);
        System.out.println("invoke after");
        return invoke;
    }
}
