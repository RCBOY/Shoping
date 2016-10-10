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
        List<Product> starList=new ArrayList<>();
        List<Product> fiveStarList=new ArrayList<>();
        List<Product> lastProductList=new ArrayList<>();
        List<Category> categoryList=new ArrayList<>();
        //首先查出热点类别
        for(Category category: categoryService.queryByhot(true)) {
            //根据热点类别查出相应的产品
            bigList.add(productService.queryByHotCid(category.getId()));
        }
        //根据商品star选出推荐商品
        for(Product product:productService.queryByStar(3,4)){
            starList.add(product);
        }
        //首页五星推荐
        for(Product product:productService.queryByStar(4,4)){
            fiveStarList.add(product);
        }
        //查询类别
        for(Category category:categoryService.query()){
            categoryList.add(category);
        }
        //最新上架商品
        for(Product product:productService.queryByTime(0,5)){
            lastProductList.add(product);
        }
        //把查询的bigList放入application内置对象
        appliction.setAttribute("categoryList",categoryList);
        appliction.setAttribute("lastProductList",lastProductList);
        appliction.setAttribute("fiveStarList",fiveStarList);
        appliction.setAttribute("starList",starList);
        appliction.setAttribute("bigList",bigList);
    }
}
