package cn.web1992.utils.demo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by web1992 on 2016/10/19.
 *
 * @desc java8 filter demo
 * @link http://www.concretepage.com/java/jdk-8/java-8-stream-filter-example
 */
public class FilterDemo {

    public static void main(String[] args) {

        // 找打第一个大于等于20岁的人
        Predicate<User> userPredicate = user -> user.getAge()>=20;

        Optional<User> userFirstOp = User.getUsers().stream().filter(userPredicate).findFirst();

        //  找到第一个大于等于30岁的人
        Optional<User> userFirstOp30 = User.getUsers().stream().filter(user -> user.getAge()>=30).findFirst();

        User  userFirst =  userFirstOp.get();
        System.out.println("userFirst " + userFirst);

        User  userFirst30 =  userFirstOp30.get();
        System.out.println("userFirst30 " + userFirst30);

        // 获取所有大于30岁的人
        List<User> users = User.getUsers().stream().filter(user -> user.getAge()>=20).collect(Collectors.toList());

        System.out.println("users " + users);


        //  计算所有人的年龄

        int sum = User.getUsers().stream().mapToInt(u->u.getAge()).sum();
        System.out.println("sum " + sum);



    }

}


class User {
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static List<User> getUsers() {
        List<User> list = new ArrayList<User>();
        list.add(new User(1, "Dinesh", 20));
        list.add(new User(2, "Kamal", 15));
        list.add(new User(3, "Vijay", 25));
        list.add(new User(4, "Ramesh", 30));
        list.add(new User(5, "Mahesh", 18));
        list.add(new User(6, "Mahesh", 18));
        return list;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
