package cn.web1992.utils.demo.nativemethod;

/**
 * @author web1992
 * @date 2020/10/16  11:22
 */
public class NativeMethod {

    int hello(String name) {
        return 0;
    }
}


class Cls1 {

    //int g(int i);

    native int g(double d);

}
