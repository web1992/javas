package xss;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器，对输入字符进行过滤
 *                       
 * @Filename: XssFilter.java
 * @Version: 1.0
 * @Author: 王朋
 * @Email: wpjava@163.com
 *
 */
public class XssFilter implements Filter {
    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                                                                                             throws IOException,
                                                                                             ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //H5过滤要去掉支付返回的URL
        //        if (httpServletRequest.getRequestURI().contains("alipay")
        //            || httpServletRequest.getRequestURI().contains("wxpay")) {
        //            chain.doFilter(request, response);
        //        } else {
        //            chain.doFilter(new XssHttpServletRequestWrapper(httpServletRequest), response);
        //        }
        chain.doFilter(new XssHttpServletRequestWrapper(httpServletRequest), response);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

}
