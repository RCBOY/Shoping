package com.ztc.shop.service;

import com.ztc.shop.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@SuppressWarnings("unchecked")
public interface CategoryService extends BaseService<Category>{
    //查询类别信息，并且级联管理员
    public  List<Category> queryJoinAccount(String type,int page,int size);
    //根据关键字查询总记录数
    public  Long getCategoryCountbyType(String type);
    //根据ids删除多条类别
    public void deleteByIds(String ids);
}
