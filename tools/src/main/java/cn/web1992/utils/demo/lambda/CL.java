package cn.web1992.utils.demo.lambda;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CL {
    private native Class<?> makeClass(String name, byte[] bytes);

    static {
//        System.loadLibrary("cn.web1992.cl.CL");
    }

//    public native void DisplayHello();

    public static void main(String[] args) throws Exception {

//        new cn.web1992.cl.CL().DisplayHello();

        byte[] bytes = Files.readAllBytes(Paths.get("/Users/zl/Documents/DEV/github/c-plus-plus/classloader/Main.class"));
//        Class<?> zz = new cn.web1992.cl.CL().makeClass("cn.web1992.cl.CL", bytes);
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