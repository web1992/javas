package cn.web1992.utils.demo.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * desc: LinkedHashMap
 * <p>
 * Version		1.0.0
 *
 * @author web1992
 * <p>
 * Date	      2019/2/11 16:19
 * <p>
 * 代码输出：
 * <pre>
 *     {a=a1, b=b1, c=c1}
 *     a1
 *     {b=b1, c=c1, a=a1}
 * </pre>
 */
public class LinkedHashMapTest2 {
    public static void main(String[] args) {


        Map<Book, Book> hashMap = new HashMap<>();
        Map<Book, Book> linkedHashMap = new LinkedHashMap<>();
        // 添加三本书
        addBooks(hashMap);
        // 打印顺序
        System.out.println("hashMap " + hashMap);

        // 添加三本书
        addBooks(linkedHashMap);
        // 打印顺序
        System.out.println("linkedHashMap " + linkedHashMap);
        // 打印结果:
        // hashMap       {book 1=book 1, book 2=book 2, book 3=book 3}
        // linkedHashMap {book 1=book 1, book 3=book 3, book 2=book 2}

        // 从打印的顺序看出
        // 当 hashMap 中放入了id =1 的 两个对象之后
        // 放入的顺序是 1->3->2
        // 打印的顺序是 1->2->3
        // 原因是 hashMap 底层是通过 hashcode 方法计算元素在 hashMap 中的位置
        // book1 和 book2 的产生了 hash 冲突 (重写了 Book 的 hashCode 方法)
        // 导致 hashMap 形成链表,从而导致遍历顺序与插入顺序不一致

        // 而 linkedHashMap 实现了有序的功能
        // 可保证插入顺序和打印顺序是一致的
    }

    private static void addBooks(Map<Book, Book> mapBooks) {
        Book book = new Book(1, "book 1");
        mapBooks.put(book, book);

        Book book3 = new Book(3, "book 3");
        mapBooks.put(book3, book3);

        Book book2 = new Book(1, "book 2");
        mapBooks.put(book2, book2);
    }

    static class Book {

        private int id;
        private String name;

        Book(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        /**
         * 重写了 hashCode 使用 id 当做 hashcode
         */
        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
