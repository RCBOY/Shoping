package com.ztc.shop.Listener;

import com.ztc.shop.model.Category;
import com.ztc.shop.model.Product;
import com.ztc.shop.service.CategoryService;
import com.ztc.shop.service.ProductService;
import com.ztc.shop.unit.ProductTimerTaskUntil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


/**
 * Description：用来初始化数据的监听器
 * Created by ZTCJoe on 2016/9/24.
 */
public class InitDataListener implements ServletContextListener {
    private ApplicationContext context=null;
    private ProductTimerTaskUntil productTimerTaskUntil=null;
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
    //    通过工具类加载
        context= WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        productTimerTaskUntil=(ProductTimerTaskUntil) context.getBean("productTimerTask");
        //把内置对象交给TimerTaskUtil
        productTimerTaskUntil.setAppliction(servletContextEvent.getServletContext());
        //通过定时器设置同步的时间间隔,配置为守护线程
        new Timer(true).schedule(productTimerTaskUntil,0,1000*60*60);
    }
}
