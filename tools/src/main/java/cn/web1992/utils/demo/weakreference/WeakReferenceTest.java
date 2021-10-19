package cn.web1992.utils.demo.weakreference;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author web1992
 * @date 2021/10/19  4:42 下午
 *
 * <p>
 * -XX:+PrintGCDetails
 * </p>
 */
public class WeakReferenceTest {


    public static void main(String[] args) {
        Cache<Person> cache = new Cache<>(new Person("Lucy"));
        System.out.println("cache is " + cache.getDate());

        try {
            System.gc();
            TimeUnit.SECONDS.sleep(5);
            System.out.println("cache is " + cache.getDate());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Person {

    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Person： " + name + " finalize。");
    }
}

class Cache<T> extends WeakReference<T> {


    public Cache(T referent) {
        super(referent);
    }

    public T getDate() {
        return get();
    }


}
