package cn.web1992.utils.demo.lambda;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CL {
    private native Class<?> makeClass(String name, byte[] bytes);

    static {
//        System.loadLibrary("CL");
    }

//    public native void DisplayHello();

    public static void main(String[] args) throws Exception {

//        new CL().DisplayHello();

        byte[] bytes = Files.readAllBytes(Paths.get("/Users/zl/Documents/DEV/github/c-plus-plus/classloader/Main.class"));
//        Class<?> zz = new CL().makeClass("CL", bytes);
        Class<?> zz = Main.class;
        System.out.println("zz is " + zz);

        Method method = zz.getMethod("main", String[].class);
        String[] _args = new String[]{};
        method.invoke((Object) null, (Object) _args);
    }

    public static void work() {
        System.out.println("work");
    }


}