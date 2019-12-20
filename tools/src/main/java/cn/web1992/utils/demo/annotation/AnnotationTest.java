package cn.web1992.utils.demo.annotation;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author web1992
 * @date 2019/12/20  16:18
 */
public class AnnotationTest {
    public static void main(String[] args) {

        // declaredFields is empty
        Field[] declaredFields = A.class.getFields();

        Arrays.asList(declaredFields).forEach(f -> {
            System.out.println(f.getName());
        });
    }
}


@interface A {

    String value();

    boolean required() default true;
}
