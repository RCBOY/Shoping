package com.ztc.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

/**
 * Description：此Action用来完成web-inf中jsp请求转发的功能，此action不处理任何的逻辑
 * Created by ZTCJoe on 2016/9/18.
 */
@Controller
public class SendAction extends ActionSupport{
    public String execute(){
    return "send";
    }
}
