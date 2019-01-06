package cn.web1992.utils.demo.volecity;

import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.*;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

public class HelloVelocity {

    public static void main(String[] args) throws Exception {



        String _path="D:\\github\\javas\\java_note\\app_tools\\src\\main\\java\\cn\\web1992\\utils\\demo\\volecity";

        // 初始化并取得Velocity引擎
        VelocityEngine ve = new VelocityEngine();

        // 取得velocity的模版
        Properties p = new Properties();
        p.put(Velocity.FILE_RESOURCE_LOADER_PATH, _path);
        ve.init(p);

        //取得velocity的模版
        Template t = ve.getTemplate("hellovelocity.vm", "utf-8");

        // 取得velocity的上下文context
        VelocityContext context = new VelocityContext();

        // 把数据填入上下文
        context.put("name", "Liang");
        context.put("date", (new Date()).toString());

        // 为后面的展示，提前输入List数值
        List temp = new ArrayList();
        temp.add("item1");
        temp.add("item2");
        context.put("list", temp);
        List tempBean = new ArrayList();
        tempBean.add(new UserInfo("1", "张三", "福建"));
        tempBean.add(new UserInfo("2", "李四", "湖南"));
        context.put("listBean", tempBean);

        // 输出流
        StringWriter writer = new StringWriter();
        // 转换输出
        t.merge(context, writer);
        // 输出信息
        System.out.println(writer.toString());

        // 输出到文件
        FileOutputStream of = new FileOutputStream(_path+"\\velocity.txt");
        of.write(writer.toString().getBytes("utf-8"));
        of.flush();
        of.close();
    }
}
