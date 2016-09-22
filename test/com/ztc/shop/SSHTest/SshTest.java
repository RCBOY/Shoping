package com.ztc.shop.SSHTest;

import com.ztc.shop.model.Category;
import com.ztc.shop.model.Product;
import com.ztc.shop.service.CategoryService;
import com.ztc.shop.service.ProductService;
import net.sf.json.JSONSerializer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Description：test
 * Created by ZTCJoe on 2016/9/14.
 */
//@ContextConfiguration(locations = "classpath:/Application-*.xml")

public class SshTest {
    private CategoryService categoryService;
    private ProductService productService;


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
    @Test
    public void test3() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/Application-public.xml");
        categoryService = applicationContext.getBean(CategoryService.class);
         categoryService.deleteByIds("6,7");
    }
    @Test
    public void test4() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/Application-public.xml");
        productService = applicationContext.getBean(ProductService.class);
      for(Product product:productService.queryJoinCategory("",1,100)){
          //product.getCategory().setAccount(null);
          System.out.println(JSONSerializer.toJSON(product));
      }

    }
}
