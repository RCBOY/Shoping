package com.ztc.shop.SSHTest;

import com.ztc.shop.model.Category;
import com.ztc.shop.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Description：test
 * Created by ZTCJoe on 2016/9/14.
 */
@ContextConfiguration(locations = "classpath:/Application-*.xml")
public class SshTest {
    ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("/Application-service.xml");
   //@Autowired
   //private Date date;
   // @Resource
   // private CategoryService categoryService;
    @Test
    public void testSpring(){
        //Date date=(Date) ctx.getBean("date");
        //System.out.print(date);
    }
    @Test
    public void testHibernate(){
        CategoryService categoryService=(CategoryService) ctx.getBean("CategoryServiceImp");
        categoryService.save(new Category("男士服饰",false));
    }
    @Test
    public void testHibernateUpdate(){
        CategoryService categoryService=(CategoryService) ctx.getBean("CategoryServiceImp");
        categoryService.update(new Category(1,"女人服饰kk",true));
    }
}
