package cn.web1992.utils.demo.factory;

/**
 * Created by web1992 on 2016/8/29.
 *
 * @desc  抽象工厂模式，解决对象的创建问题, 同时也符合 开闭原则  开放扩展，关闭修改
 *
 */
public class TestFactory {
    public static void main(String[] args) {

        PeopleAbstractFactory stuFactory=new StudentFactory();
        People stu= stuFactory.create();


        PeopleAbstractFactory tecFactory=new TeacherFactory();
        People tec= tecFactory.create();


        System.out.println(stu);
        System.out.println(tec);



    }
}
