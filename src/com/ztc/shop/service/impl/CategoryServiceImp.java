package com.ztc.shop.service.impl;

import com.ztc.shop.model.Category;
import com.ztc.shop.service.CategoryService;
import com.ztc.shop.unit.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description：模块自身的业务逻辑
 * Created by ZTCJoe on 2016/9/14.
 */
@SuppressWarnings("unchecked")
@Service("categoryService")
public class CategoryServiceImp extends BaseServiceImp<Category> implements CategoryService{
    public CategoryServiceImp(){
        super();
    }

    @Override
    public List<Category> queryJoinAccount(String type) {
       return getSession().createQuery("FROM Category c where c.type=:type")
                .setString("type","%"+type+"%")
                .list();
    }
}
