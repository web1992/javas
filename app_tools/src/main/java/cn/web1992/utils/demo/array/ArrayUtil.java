package cn.web1992.utils.demo.array;

import java.lang.reflect.Array;

/**
 * @author web1992
 * @deta 2017/1/3
 * @desc 两个数组合并
 */
public class ArrayUtil {

    public static <T> T[] concat(T[] t1, T[] t2) {
        if (null == t1 && t2 == null) {
            return null;
        }
        T[] result = (T[]) Array.newInstance(t1.getClass().getComponentType(), t1.length + t2.length);

        System.arraycopy(t1, 0, result, 0, t1.length);
        System.arraycopy(t2, 0, result, t1.length, t2.length);

        return result;
    }


    public static void main(String[] args){
        String[] a1=new String[]{"1","2"};
        String[] a2=new String[]{"A","B"};

        String[] concat = ArrayUtil.concat(a1, a2);

       for(String e:concat){
           System.out.println(e);
       }

    }
}

/**
 * 　┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　┃　　　┃    神兽保佑,代码无bug
 * 　　┃　　　┃
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　 ┣┓
 * 　　┃　　　　 ┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 */