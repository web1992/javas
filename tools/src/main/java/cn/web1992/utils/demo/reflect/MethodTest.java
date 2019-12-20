package cn.web1992.utils.demo.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author web1992
 * @date 2019/12/20  13:43
 * java 桥接方法测试
 */
public class MethodTest {
    public static void main(String[] args) {


        Sub sub = new Sub();

        // 获取所有 public 方法
        Method[] methods = sub.getClass().getMethods();
        // 获取所有自己生命的方法
        Method[] declaredMethods = sub.getClass().getDeclaredMethods();

        Arrays.asList(methods).forEach(method -> {
            // System.out.println("methods is [" + method.getName() + "]");
        });

        Arrays.asList(declaredMethods).forEach(method -> {
            System.out.println("declaredMethods is [" + method.getName() + "] is bridge method [" + method.isBridge() + "]");
            System.out.println();
            Class<?>[] parameterTypes = method.getParameterTypes();
            Arrays.asList(parameterTypes).forEach(p -> System.out.println(p.getName()));
        });
    }
}


interface Super<T> {
    void say(T t);
}

class Sub implements Super<String> {

    @Override
    public void say(String s) {
    }

    private void privateSay() {

    }
}