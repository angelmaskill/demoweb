package com.tuling;

import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: AngelMa
 * @Description:
 * @Date: Created on 2021/7/22 10:02 上午
 * @Modified By:
 */
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before do filter!");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("after do filter!");
    }

    @Override
    public void destroy() {

    }
}
