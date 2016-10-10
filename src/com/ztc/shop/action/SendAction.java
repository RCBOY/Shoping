package com.ztc.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ztc.shop.model.Account;
import com.ztc.shop.model.Product;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Description：此Action用来完成web-inf中jsp请求转发的功能，此action不处理任何的逻辑
 * Created by ZTCJoe on 2016/9/18.
 */
@Controller
public class SendAction extends BaseAction<Account>{
    public String execute(){
        if (session.get("accountLogin")==null)
        {
            return "AdminLogin";
        }
         return "send";
    }
}
