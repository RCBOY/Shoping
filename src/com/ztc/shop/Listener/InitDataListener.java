package com.ztc.shop.Listener;

import com.mysql.jdbc.Driver;
import com.ztc.shop.model.Product;
import com.ztc.shop.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;


/**
 * Description：用来初始化数据的监听器
 * Created by ZTCJoe on 2016/9/24.
 */
public class InitDataListener implements ServletContextListener {
    ProductService productService=null;
    @Override
    public void contextDestroyed (ServletContextEvent servletContextEvent) {
        //Enumeration<java.sql.Driver> drivers= DriverManager.getDrivers();
        //while (drivers.hasMoreElements()) {
        //    java.sql.Driver driver = drivers.nextElement();
        //    try {
        //        DriverManager.deregisterDriver(driver);
        //    } catch (SQLException e) {
        //        e.printStackTrace();
        //    }
        //}
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    //注入Service，直接到ServletContext中获取Spring文件,但此方法不常用
    //    ApplicationContext context=(ApplicationContext) servletContextEvent.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    //    productService=(ProductService) context.getBean("productService");
    //    System.out.println(productService);
        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        productService=(ProductService) webApplicationContext.getBean("productService");
        System.out.println(productService);
    }
}
