package cn.web1992.utils.demo.java8;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2016/11/3.
 */
public class MainNullCheck {

    public static void main(String[] args) {
        Optional.of(new Outer())
                .map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);


        Outer obj = new Outer();
        resolve(() -> obj.getNested().getInner().getFoo()).ifPresent(System.out::println);


        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                }).forEach(System.out::println);


        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

    }


    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

}


class Outer {
    Nested nested;

    Nested getNested() {
        return nested;
    }
}

class Nested {
    Inner inner;

    Inner getInner() {
        return inner;
    }
}

class Inner {
    String foo;

    String getFoo() {
        return foo;
    }
}
