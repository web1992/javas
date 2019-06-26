package cn.web1992.utils.demo.classloader;

public interface ClassInterface {

    int a = 1;
}


class Test {
    public static void main(String[] args) {
        System.out.println(ClassInterface.a);
        // ClassInterface.a=2;
    }
}