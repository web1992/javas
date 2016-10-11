package cn.web1992.utils.demo.reflect;

import java.lang.reflect.Field;

/**
 * @desc java 反射demo
 *        利用java的反射技术，可以动态的改变类的属性
 */
public class ReflectDemo {

    private String code = "1";

    private Actor actor=null;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        ReflectDemo demo = new ReflectDemo();

        System.out.println("before value=" + demo.code);
        System.out.println("before value=" + demo.actor);


        Field field = demo.getClass().getDeclaredField("code");
        // 设置变量可访问
        field.setAccessible(true);
        // 修改变量的值
        field.set(demo, "2");

        // 获取属性actor
        Field actorField = demo.getClass().getDeclaredField("actor");
        // 修改属性actor
        actorField.set(demo,new Actor("Lucy"));

        System.out.println("after value=" + demo.code);
        System.out.println("after value=" + demo.actor);
    }
}

class Actor{
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                '}';
    }
}