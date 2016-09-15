package com.ztc.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ztc.shop.model.Category;
import com.ztc.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/14.
 */
public class CategoryClassAction extends ActionSupport{
    public Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryService categoryService;

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public  String  update(){
        System.out.println("update");
        System.out.println(categoryService);
        categoryService.update(category);
        return "index";
    }
    public  String  save(){
        System.out.println("save");
        System.out.println(categoryService);
        return "index";
    }
}
