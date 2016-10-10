package com.ztc.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.ztc.shop.model.Account;
import com.ztc.shop.model.Category;
import org.junit.Test;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * Description：做转发
 * Created by ZTCJoe on 2016/9/14.
 */
@Controller
@Scope("prototype")
public class AccountClassAction extends BaseAction<Account> {
    public AccountClassAction() {
    }
    public String Login(){
        model=accountService.Login(model);
        if (model==null){
            session.put("acccountError","用户名或账号错误");
            return "accountLogin";
        }{
            session.put("accountLogin",model);
            return "aindex";
        }
    }

    public String query(){
        jsonList =new ArrayList<Account>();
        jsonList=accountService.query();
        return "jsonDataList";
    }
}
