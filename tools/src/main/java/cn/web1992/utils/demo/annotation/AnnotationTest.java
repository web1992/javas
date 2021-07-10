package cn.web1992.utils.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author web1992
 * @date 2019/12/20  16:18
 */
public class AnnotationTest {
    public static void main(String[] args) {

        getAnnoFromInterface();
    }


    public static void getAnnoFromInterface() {

        A annotation = Demo.class.getAnnotation(A.class);

        System.out.println(annotation);

    }

    public static void getAnnoFromClass() {

        Annotation[] annotations = DemoImpl.class.getAnnotations();

        for (Annotation ann : annotations) {
            System.out.println("ann");
        }
    }

    public static void getDemoImplAnn() {
        Method[] methods = new DemoImpl().getClass().getMethods();

        for (Method m : methods) {
            A annotation = m.getAnnotation(A.class);
            //System.out.println(m.getName());
            if (annotation != null) {
                System.out.println("find annotation");
            }
        }
    }

    public static void testGetFields() {
        // declaredFields is empty
        Field[] declaredFields = A.class.getFields();
        Arrays.asList(declaredFields).forEach(f -> {
            System.out.println(f.getName());
        });
    }

}


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@interface A {

    String value();

    boolean required() default true;
}


@A(value = "1")
interface Demo {

    @A(value = "1")
    void run();

}

@A(value = "1")
class DemoImpl implements Demo {

    @Override
    //@A(value = "1")
    public void run() {

    }
}
