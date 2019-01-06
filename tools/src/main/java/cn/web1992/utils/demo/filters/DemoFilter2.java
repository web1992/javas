package cn.web1992.utils.demo.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by web1992 on 2016/9/27.
 *
 * @desc
 */
public class DemoFilter2 implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("DemoFilter2 init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("DemoFilter2 do");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("DemoFilter2 destroy");
    }
}
