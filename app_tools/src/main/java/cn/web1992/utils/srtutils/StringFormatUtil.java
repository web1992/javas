package cn.web1992.utils.srtutils;

import java.util.Formatter;

/**
 * Created by web1992 on 2016/7/29.
 *
 * @desc 字符串格式工具
 *
 */
public class StringFormatUtil {

    private final static  Formatter format = new Formatter();

    public static String format(String str,String ... vars){
       return format.format(str,vars).toString();
    }

    /**
     * @desc 使用方法
     * @param args
     */
    public static void main(String args[]){

        System.out.println(StringFormatUtil.format("{%s},{%s}","a","b"));

    }


}
