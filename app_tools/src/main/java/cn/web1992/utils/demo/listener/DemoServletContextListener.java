package cn.web1992.utils.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by web1992 on 2016/9/27.
 *
 * @desc
 */
public class DemoServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("DemoServletContextListener init ");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("DemoServletContextListener destroyed ");
    }
}
