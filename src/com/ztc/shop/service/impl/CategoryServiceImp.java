package com.ztc.shop.service.impl;

import com.ztc.shop.model.Category;
import com.ztc.shop.service.CategoryService;
import com.ztc.shop.unit.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Description：category Service 方法的具体实现类
 * Created by ZTCJoe on 2016/9/14.
 */
public class CategoryServiceImp implements CategoryService {

    private SessionFactory sessionFactory;
    protected Session getSession(){
        return  sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    //未整合Spring是的写法
    public void save(Category category) {
        //    通过工具类获取session
        Session session= HibernateSessionFactory.getSession();
       try{
        //    手动开启事务
        session.getTransaction().begin();
       //    执行保存方法
        session.save(category);
        //提交事务
        session.getTransaction().commit();
       }catch (Exception e){
           session.getTransaction().rollback();
           throw new RuntimeException(e);
       }finally {
           HibernateSessionFactory.closeSession();
       }
    }

    @Override
    public void update(Category category) {
        getSession().update(category);
    }
}
