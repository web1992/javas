package cn.web1992.utils.demo.f;

public class FieldTest {

    public static void main(String[] args) {

        Demo demo = new Demo();

        demo.name = "hello";
        System.out.println(demo.name);


        demo.setName("world");
        System.out.println(demo.getName());
    }


    public static class Demo {

        public String name;


        public String getName() {
            return name;
        }

        public Demo setName(String name) {
            this.name = name;
            return this;
        }


    }
}
