package com.ztc.shop.Listener;

import com.ztc.shop.model.Category;
import com.ztc.shop.model.Product;
import com.ztc.shop.service.CategoryService;
import com.ztc.shop.service.ProductService;
import com.ztc.shop.unit.FileUpload;
import com.ztc.shop.unit.NoticeTimerTaskUntil;
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
    private NoticeTimerTaskUntil noticeTimerTaskUntil=null;
    private FileUpload fileUpload=null;
    @Override
    public void contextDestroyed (ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
    //    通过工具类加载
        context= WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        productTimerTaskUntil=(ProductTimerTaskUntil) context.getBean("productTimerTask");
        noticeTimerTaskUntil= (NoticeTimerTaskUntil) context.getBean("noticeTimerTask");
        fileUpload=(FileUpload) context.getBean("fileUpload");

        //把内置对象交给TimerTaskUtil
        productTimerTaskUntil.setAppliction(servletContextEvent.getServletContext());
        noticeTimerTaskUntil.setAppliction(servletContextEvent.getServletContext());
        //通过定时器设置同步的时间间隔,配置为守护线程
        new Timer(true).schedule(productTimerTaskUntil,0,1000*60*60);
        new Timer(true).schedule(noticeTimerTaskUntil,0,1000*60*60);
        //   直接加载银行图标
        servletContextEvent.getServletContext().setAttribute("bankList",fileUpload.getBankIamages());
    }
}
