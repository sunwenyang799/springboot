package com.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 21:41 2020/10/20
 * @ Description：自定义filter
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter process...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
