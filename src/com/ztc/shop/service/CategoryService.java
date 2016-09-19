package com.ztc.shop.service;

import com.ztc.shop.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@SuppressWarnings("unchecked")
public interface CategoryService extends BaseService<Category>{
    //查询类别信息，级联管理员
    public  List<Category> queryJoinAccount(String type);
}
