package com.ztc.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ztc.shop.model.Category;
import com.ztc.shop.service.CategoryService;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/14.
 */
@Controller
@Scope("prototype")
public class CategoryClassAction extends BaseAction<Category> {
    //protected Map<String,Object> request;
    //protected Map<String,Object> application;
    //protected Map<String,Object> session;
    public CategoryClassAction() {
    }

    public  String  update(){
        System.out.println("update");
        System.out.println(categoryService);
        System.out.println(model);

        return "index";
    }

    public  String  save(){
        System.out.println("save");
        System.out.println(categoryService);
        System.out.println(model);

        return "index";
    }
    public String query(){
        //解决方案1：采用相应的map，取代了原来的内置方法，这样与jsp没有依赖，但代码量大
        //ActionContext.getContext().put("CategoryList",categoryService.query());
        //ActionContext.getContext().getSession().put("CategoryList",categoryService.query());
        //ActionContext.getContext().getApplication().put("CategoryList",categoryService.query());
        //解决方案2：实现相应的接口，让相应的map注入
        //解决方案3：实现相应的接口，让相应的map注入,将其放入相应的BaseAction
        System.out.print(ActionContext.getContext().getValueStack().getRoot());
        request.put("CategoryList",categoryService.query());
        session.put("CategoryList",categoryService.query());
        application.put("CategoryList",categoryService.query());
        return "index";
    }

}
