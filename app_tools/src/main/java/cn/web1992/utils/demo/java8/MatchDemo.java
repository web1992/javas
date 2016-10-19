package cn.web1992.utils.demo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by web1992 on 2016/10/19.
 *
 * @desc java8 match demo
 * @link http://www.concretepage.com/java/jdk-8/java-8-stream-allmatch-anymatch-nonematch-example
 * 三个方法测试
 * allMatch
 * anyMatch
 * noneMatch
 */
public class MatchDemo {
    public static void main(String[] args) {

        Predicate<Employee> predicateEm = employee -> employee.sal > 2000 && employee.name.equals("V");

        Predicate<Employee> predicateEm2 = employee -> employee.sal >= 2000;

        boolean anyMatch = Employee.getEmpList().stream().anyMatch(predicateEm);

        boolean allMatch = Employee.getEmpList().stream().allMatch(predicateEm);

        boolean noneMatch = Employee.getEmpList().stream().noneMatch(predicateEm);

        System.out.println(anyMatch);   // false
        System.out.println(allMatch);   // false
        System.out.println(noneMatch);  // true


        boolean anyMatch2 = Employee.getEmpList().stream().anyMatch(predicateEm2);

        boolean allMatch2 = Employee.getEmpList().stream().allMatch(predicateEm2);

        boolean noneMatch2 = Employee.getEmpList().stream().noneMatch(predicateEm2);

        System.out.println("==============================");

        System.out.println(anyMatch2);   // true
        System.out.println(allMatch2);   // true
        System.out.println(noneMatch2);  // false


    }


}


class Employee {
    public int id;
    public String name;
    public int sal;

    public Employee(int id, String name, int sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public static List<Employee> getEmpList() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "A", 2000));
        list.add(new Employee(2, "B", 3000));
        list.add(new Employee(3, "C", 4000));
        list.add(new Employee(4, "D", 5000));
        return list;
    }
}


