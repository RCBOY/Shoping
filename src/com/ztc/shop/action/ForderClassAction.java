package com.ztc.shop.action;

import com.ztc.shop.model.*;
import com.ztc.shop.service.AddressService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/1.
 */
@Controller
@Scope("prototype")
public class ForderClassAction extends BaseAction<Forder> {
    //接收页面传入的address选项值
    private String aid;

    public String getAid() {
        return aid;
    }
    public void setAid(String aid) {
        this.aid = aid;
    }

    //将session中的forder注入到model中
    @Override
    public Forder getModel() {
        model=(Forder) session.get("forder");
        return model;
    }

    //    实现订单与购物项的级联入库
    public String save(){
        model.setAddress(addressService.get(Integer.parseInt(aid)));
        model.setStatus(new Status(1));
        model.setUser((User) session.get("user"));
        System.out.println(model.getRemark());
        forderService.save(model);
        session.put("oldforder",session.remove("forder"));
        return "bank";
    }
}
