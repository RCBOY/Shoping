package com.ztc.shop.service.impl;

import com.ztc.shop.model.Category;
import com.ztc.shop.service.BaseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Description：BaseService接口的具体实现类
 * Created by ZTCJoe on 2016/9/15.
 */
@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImp<T> implements BaseService<T> {
    //存储了当前操作泛型的类型
    private Class clazz;
    @Resource  //没有制定名称默认属性的名称与id捆绑
   private SessionFactory sessionFactory;
    Session getSession(){
        return  sessionFactory.getCurrentSession();
    }

    public BaseServiceImp(){
        //通过反射获取类类型
        ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) type.getActualTypeArguments()[0];
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
