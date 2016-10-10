package com.ztc.shop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description：后台登入过滤器
 * Created by ZTCJoe on 2016/10/9.
 */
public class AccountFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        if (request.getSession().getAttribute("accountLogin")==null){
            response.sendRedirect(request.getContextPath()+"/AdminLogin/adminLogin.jsp");
        }else{
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
