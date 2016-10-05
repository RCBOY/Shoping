package com.ztc.shop.SSHTest;

import com.ztc.shop.model.Address;
import com.ztc.shop.model.Category;
import com.ztc.shop.model.Product;
import com.ztc.shop.model.Sorder;
import com.ztc.shop.service.*;
import com.ztc.shop.service.impl.SorderServiceImp;
import com.ztc.shop.unit.EmailUtil;
import com.ztc.shop.unit.EmailUtilImp;
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
    private AddressService addressService;
    private ForderService forderService;
    private EmailUtil emailUtil;
    private SorderService sorder;


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
          //System.out.println(JSONSerializer.toJSON(product));
          System.out.println(product);
      }

    }
    @Test
    public void test5(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/Application-public.xml");
        productService = applicationContext.getBean(ProductService.class);
        productService.delete(4);
    }
    @Test
    public void  text6(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/Application-public.xml");
        productService = applicationContext.getBean(ProductService.class);
        Product product= productService.get(2);
        product.setId(110);
        product.setPic("jjj");
        productService.save(product);
    }
    @Test
    public void  text7(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/Application-public.xml");
        productService = applicationContext.getBean(ProductService.class);
        categoryService=applicationContext.getBean(CategoryService.class);
        //首先查出热点类别
        for(Category category: categoryService.queryByhot(true)) {
            //根据热点类别查出相应的产品
            System.out.println(productService.queryByHotCid(category.getId()));
        }

    }
    @Test
    public void  text8(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/Application-public.xml");
        addressService = applicationContext.getBean(AddressService.class);
        for(Address address: addressService.getAddressByUid(2)) {
            //根据热点类别查出相应的产品
            System.out.println(address.getAddressname());
        }
    }
    @Test
    public void  text9(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/Application-public.xml");
        forderService = applicationContext.getBean(ForderService.class);
        forderService.updateStatusById(2016092117,2);
    }
    @Test
    public void  text10(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/Application-public.xml");
        emailUtil = applicationContext.getBean(EmailUtilImp.class);
        emailUtil.sendEmail("329942954@qq.com","212121");
    }
    @Test
    public void  text11(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/Application-public.xml");
        sorder = applicationContext.getBean(SorderService.class);
        JSONSerializer.toJSON(sorder.querySale(5));
    }
    }

