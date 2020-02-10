package cn.web1992.utils.demo.objects;

/**
 * @author web1992
 * @date 2020/2/10  19:58
 */
public class Objects {
    public static void main(String[] args) {
        Object obj = "abc";
        try {
            obj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
