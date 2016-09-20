package com.ztc.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.ztc.shop.model.Account;
import com.ztc.shop.model.Category;
import org.junit.Test;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Description：做转发
 * Created by ZTCJoe on 2016/9/14.
 */
@Controller
@Scope("prototype")
public class AccountClassAction extends BaseAction<Account> {

    public AccountClassAction() {

    }
    public  String  update(){
        System.out.println("update");
        System.out.println(categoryService);
        System.out.println(model);
        accountService.update(model);
        return "index";
    }

    public  String  save(){
        System.out.println("save");
        System.out.println(accountService);
        System.out.println(model);
        accountService.save(model);
        return "index";
    }
    public String delete(){
        accountService.delete(model.getId());
        return "index";
    }
    public String get(){
        System.out.println(accountService.get(model.getId()));
        return "index";
    }
    public String query(){
        System.out.print(ActionContext.getContext().getValueStack().getRoot());
        request.put("AccountList",accountService.query());
        session.put("AccountList",accountService.query());
        application.put("AccountList",accountService.query());
        return "index";
    }

}
