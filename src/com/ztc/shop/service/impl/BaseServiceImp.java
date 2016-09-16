package com.ztc.shop.service.impl;

import com.ztc.shop.service.BaseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/15.
 */
@SuppressWarnings("unchecked")
public class BaseServiceImp<T> implements BaseService<T> {
    //存储了当前操作的类型
    private Class clazz;
   private SessionFactory sessionFactory;
    protected Session getSession(){
        return  sessionFactory.getCurrentSession();
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public BaseServiceImp(){
        System.out.println("this代表当前构造方法的对象"+this);
        System.out.println("获取当前对想的父类信息包（括泛型信息）"+this.getClass().getGenericSuperclass());
        ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
        clazz=(Class) type.getActualTypeArguments()[0];
    }
    @Override
    public void save(T t) {
        getSession().save(t);
    }

    @Override
    public void update(T t) {
        getSession().update(t);

    }

    @Override
    public void delete(int id) {
        String hql="DELETE "+clazz.getSimpleName()+" c where c.id=:id";
        getSession().createQuery(hql).setInteger("id",id).executeUpdate();
    }

    @Override
    public T get(int id) {
        return (T) getSession().get(clazz,id);

    }

    @Override
    public List<T> query() {
        String hql="FROM "+clazz.getSimpleName();
        return  getSession().createQuery(hql).list();
    }
}
