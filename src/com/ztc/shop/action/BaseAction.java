package com.ztc.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ztc.shop.model.FileImage;
import com.ztc.shop.service.*;
import com.ztc.shop.unit.EmailUtil;
import com.ztc.shop.unit.FileUpload;
import com.ztc.shop.unit.MessageUtil;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Description：是所有Action的父类，存有一些公用的方法
 * Created by ZTCJoe on 2016/9/16.
 */
@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {
    //获取FileImage对象，封装了文件上传的属性
    protected FileImage fileImage;
    //获取要删除的ids以及流
    protected String ids;
    protected InputStream inputStream;

    //获取分页分必要属性
    protected int page;
    protected int rows;
    //用来存储分页返回数据
    protected  Map<String,Object> pageMap=null;
    //用于返回列表
    protected List<T> jsonList=null;
    //注入各种Map
    protected Map<String,Object> request;
    protected Map<String,Object> application;
    protected Map<String,Object> session;
    protected T model;
    //Service的注入
    @Resource
    public CategoryService categoryService;
    @Resource
    public AccountService accountService;
    @Resource
    public ProductService productService;
    @Resource
    public SizeService sizeService;
    @Resource
    public ColorService colorService;
    @Resource
    public ForderService forderService;
    @Resource
    public  SorderService sorderService;
    @Resource
    public  UserService userService;
    @Resource
    public AddressService addressService;
    @Resource
    public PayService payService;
    @Resource
    public FileUpload fileUpload;
    @Resource
    public EmailUtil emailUtil;
    @Resource
    public MessageUtil messageUtil;
    // 构造器
    public BaseAction() {
        super();
    }

    public FileImage getFileImage() {
        return fileImage;
    }

    public void setFileImage(FileImage fileImage) {
        this.fileImage = fileImage;
    }

    public List<T> getJsonList() {
        return jsonList;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getIds() {
        return ids;
    }

    public Map<String, Object> getPageMap() {
        return pageMap;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getRows() {
        return rows;
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
