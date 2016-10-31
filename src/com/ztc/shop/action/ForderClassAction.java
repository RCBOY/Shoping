package com.ztc.shop.action;

import com.ztc.shop.model.*;
import com.ztc.shop.service.AddressService;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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
        model.setPost("0");
        model.setUser((User) session.get("user"));
        forderService.save(model);
        session.put("oldforder",session.remove("forder"));
        return "bank";
    }
    //查询全部的订单
    public String queryForderForAll(){
        session.remove("userforder");
        User user=(User) session.get("user");
        int uid=user.getId();
        List<Forder> list= forderService.queryByid(uid);
        session.put("userforder",list);
        session.put("queryTile","全部订单");
        return "forderQuey";
    }
    //查询已支付订单
    public String queryForderForPay(){
        session.remove("userforder");
        User user=(User) session.get("user");
        List<Forder> listForPay=forderService.getByUidAndSid(user.getId(),"2");
        session.put("userforder",listForPay);
        session.put("queryTile","已支付订单");
        return "forderQuey";
    }
    //查询未支付订单
    public String queryForderNoPay(){
        session.remove("userforder");
        User user=(User) session.get("user");
        List<Forder> listForNoPay=forderService.getByUidAndSid(user.getId(),"1");
        session.put("userforder",listForNoPay);
        session.put("queryTile","未支付订单");
        return "forderQuey";
    }
    //查询已完成订单
    public String queryForderHasOver(){
        session.remove("userforder");
        User user=(User) session.get("user");
        List<Forder> listForHasOver=forderService.getByUidAndSid(user.getId(),"4");
        session.put("userforder",listForHasOver);
        session.put("queryTile","已完成订单");
        return "forderQuey";
    }
    //查询配送中的订单
    public String queryForderOnPath(){
        session.remove("userforder");
        User user=(User) session.get("user");
        List<Forder> listForderOnPath=forderService.getByUidAndSid(user.getId(),"3");
        session.put("userforder",listForderOnPath);
        session.put("queryTile","配送中订单");
        return "forderQuey";
    }


}
