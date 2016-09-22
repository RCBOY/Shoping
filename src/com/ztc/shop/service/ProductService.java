package com.ztc.shop.service;

import com.ztc.shop.model.Category;
import com.ztc.shop.model.Product;

import java.util.List;

public interface ProductService extends BaseService<Product> {
    //查询类别信息，并且级联管理员
    public List<Product> queryJoinCategory(String name, int page, int size);
    //根据关键字查询总记录数
    public  Long getProductCountbyName(String name);
    //根据ids删除多条类别
    public void deleteByIds(String ids);
}