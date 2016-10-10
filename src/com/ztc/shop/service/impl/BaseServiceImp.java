package com.ztc.shop.service.impl;

import com.ztc.shop.dao.*;
import com.ztc.shop.model.Category;
import com.ztc.shop.service.BaseService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Description：BaseService接口的具体实现类
 * Created by ZTCJoe on 2016/9/15.
 * 注：由于BaseDao是泛型所以在被注入时是无法被创建的，所以在此处使用反射获取相关字段
 * BaseServiceImpl执行顺序：1.BaseServiceImpl构造方法--->2.注入Resource--->3.执行init方法--->4.最后执行destroy方法
 * 所以在init方法中将各个Daoimpl赋值给BaseDao
 */
@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImp<T> implements BaseService<T> {
    //存储了当前操作泛型的类型
    private Class clazz;

   // 构造器执行之后执行init方法
    @PostConstruct
    public void init(){
       // 根据clazz的类型，把不同的dao对象赋值给BaseDao
       String clazzname= clazz.getSimpleName();
       String clazzDao= clazzname.substring(0,1).toLowerCase()+clazzname.substring(1)+"Dao";//ex:Account-->accountDao
    //    this代表的是调用当前方法的子类对象
        try{
            //getField方法能得到父类的字段
            Field clazzField= this.getClass().getSuperclass().getDeclaredField(clazzDao);
           Field baseDaoFiled=this.getClass().getSuperclass().getDeclaredField("baseDao");
            baseDaoFiled.set(this,clazzField.get(this));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

   // @Resource
    protected BaseDao baseDao;
    @Resource
    protected AccountDao accountDao;
    @Resource
    protected AddressDao addressDao;
    @Resource
    protected CategoryDao categoryDao;
    @Resource
    protected ColorDao colorDao;
    @Resource
    protected ForderDao forderDao;
    @Resource
    protected ProductDao productDao;
    @Resource
    protected SizeDao sizeDao;
    @Resource
    protected SorderDao sorderDao;
    @Resource
    protected UserDao userDao;
    @Resource
    protected NoticeDao noticeDao;


    public BaseServiceImp(){
        //通过反射获取类类型
        ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) type.getActualTypeArguments()[0];
    }

    @Override
    public void save(T t) {
        //getSession().save(t);
       baseDao.save(t);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public void delete(int id) {
        baseDao.delete(id);
    }

    @Override
    public T get(int id) {
      return (T) baseDao.get(id);
    }

    @Override
    public List<T> query() {
        return  baseDao.query();
    }
}
