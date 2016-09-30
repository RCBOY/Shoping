package com.ztc.shop.unit;

import com.ztc.shop.model.Category;
import com.ztc.shop.model.Product;
import com.ztc.shop.service.CategoryService;
import com.ztc.shop.service.ProductService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Description：通过run方法定时加载首页商品信息的工具类
 * Created by ZTCJoe on 2016/9/25.
 */
@Component("productTimerTask")
public class ProductTimerTaskUntil extends TimerTask {

    @Resource
    CategoryService categoryService=null;
    @Resource
    ProductService productService=null;
    private ServletContext appliction=null;

    public void setAppliction(ServletContext appliction) {
        this.appliction = appliction;
    }

    @Override
    public void run() {
        List<List<Product>> bigList=new ArrayList<List<Product>>();
        //首先查出热点类别
        for(Category category: categoryService.queryByhot(true)) {
            //根据热点类别查出相应的产品
            bigList.add(productService.queryByHotCid(category.getId()));
        }
        //把查询的bigList放入application内置对象
        appliction.setAttribute("bigList",bigList);
    }
}
