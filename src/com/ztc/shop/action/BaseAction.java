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
 * Description：
 * Created by ZTCJoe on 2016/9/16.
 */
@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {
    protected Map<String,Object> request;
    protected Map<String,Object> application;
    protected Map<String,Object> session;
    protected T model;
    @Resource
    public CategoryService categoryService;
    @Resource
    public AccountService accountService;

    //public void setAccountService(AccountService accountService) {
    //    this.accountService = accountService;
    //}
    //
    //public void setCategoryService(CategoryService categoryService) {
    //    this.categoryService = categoryService;
    //}

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

    public BaseAction() {
        super();
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
