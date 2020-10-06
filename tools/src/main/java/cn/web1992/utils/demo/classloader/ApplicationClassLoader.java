package cn.web1992.utils.demo.classloader;

public class ApplicationClassLoader {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println("ApplicationClassLoader getParent:" + Thread.currentThread().getContextClassLoader().getParent());
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());
    }
}