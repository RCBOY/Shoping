package com.ztc.shop.filter;


import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description：用户登入的过滤器
 * Created by ZTCJoe on 2016/9/30.
 */
public class UserFiter implements Filter {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        if (request.getSession().getAttribute("user")==null){
            //如果是非法请求，就保存原来的请求路径
           String url= request.getServletPath();
            String param=request.getQueryString();
            if (param!=null){
                url=url+"?"+param;
            }
            //把之前需要访问的地址存储到session
            request.getSession().setAttribute("url",url);
            request.getSession().setAttribute("error","请先登入");
            response.sendRedirect(request.getContextPath()+"/userLogin.jsp");
        }else{
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
