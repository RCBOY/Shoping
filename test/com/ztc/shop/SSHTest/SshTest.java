package com.ztc.shop.SSHTest;

import com.ztc.shop.model.Account;
import com.ztc.shop.model.Category;
import com.ztc.shop.service.AccountService;
import com.ztc.shop.service.CategoryService;
import com.ztc.shop.service.impl.CategoryServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Description：test
 * Created by ZTCJoe on 2016/9/14.
 */
//@ContextConfiguration(locations = "classpath:/Application-*.xml")

public class SshTest {
    private CategoryService categoryService;


    @Test
   public void test1() {
        ApplicationContext applicationContext =
               new ClassPathXmlApplicationContext("/Application-public.xml");
        categoryService = applicationContext.getBean(CategoryService.class);
        List<Category> categoryList = categoryService.queryJoinAccount("儿童",1,3);
        for (Category c : categoryList) {
            System.out.print(c);
            System.out.println(c.getAccount());
        }
    }
    @Test
    public void test2() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/Application-public.xml");
        categoryService = applicationContext.getBean(CategoryService.class);

        System.out.println(  categoryService.getCategoryCountbyType("儿童"));
    }
}
