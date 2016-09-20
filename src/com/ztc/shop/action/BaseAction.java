package com.ztc.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ztc.shop.model.Category;
import com.ztc.shop.service.AccountService;
import com.ztc.shop.service.CategoryService;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.junit.Test;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * Description：是所有Action的父类，存有一些公用的方法
 * Created by ZTCJoe on 2016/9/16.
 */
@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {
    //分页分必要属性
    protected int page;
    protected int size;
    //用来存储分页返回数据
    protected  Map<String,Object> pageMap=null;
    //注入各种Map
    protected Map<String,Object> request;
    protected Map<String,Object> application;
    protected Map<String,Object> session;
    protected T model;
    //注入categoryService，accountService
    @Resource
    public CategoryService categoryService;
    @Resource
    public AccountService accountService;
    public BaseAction() {
        super();
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    //实现ModelDriven后需要实现getModel方法，以实现模型驱动
    @Override
    public T getModel() {
        ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
       Class clazz=(Class)type.getActualTypeArguments()[0];
        try{
            model=(T) clazz.newInstance();

        }catch (Exception e){
        throw new RuntimeException(e);
        }
        return model;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application=application;
    }
    @Override
    public void setRequest(Map<String, Object> request) {
        this.request=request;
    }
    @Override
    public void setSession(Map<String, Object> session){
        this.session=session;
    }
}
