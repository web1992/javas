package cn.web1992.utils.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by web1992 on 2016/10/10.
 *
 * @desc url-pattern 的匹配 /* 优先于 /
 * <p>
 * <init-param>用来定义参数，可有多个init-param。
 * 在servlet类中通过getInitParamenter(String name)方法访问初始化参数
 * <load-on-startup>指定web应用启动时，装载servlet的次序。
 * 当值为负数或未定义时Servlet容器将在web客户首次访问此servlet时加载它；
 * 当值为正数或0时Servlet容器先加载数值小的servlet，当值相同时，容器就会自己选择顺序来加载。
 * -->
 * <servlet>
 * <servlet-name>demoServlet</servlet-name>
 * <servlet-class>cn.web1992.utils.demo.servlet.DemoServlet</servlet-class>
 * <load-on-startup>0</load-on-startup>
 * <init-param>
 * <param-name>demoValue</param-name>
 * <param-value>12</param-value>
 * </init-param>
 * </servlet>
 * <servlet-mapping>
 * <servlet-name>demoServlet</servlet-name>
 * <url-pattern>/</url-pattern>
 * </servlet-mapping>
 */
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demoValue=" + getInitParameter("demoValue"));
        resp.getWriter().write("hello doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("hello doPost");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("DemoServlet init");
    }
}
