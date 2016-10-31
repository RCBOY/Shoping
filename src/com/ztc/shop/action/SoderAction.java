package com.ztc.shop.action;

import com.opensymphony.xwork2.ActionContext;

import com.ztc.shop.model.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/28.
 */
@Controller("sorderAction")
@Scope("prototype")
public class SoderAction extends BaseAction<Sorder>{
    public String addSorder(){
    //根据product.id获取相对应的商品数据
      Product product= productService.get(model.getProduct().getId());
    //判断当前session是否有购物车，若没有则创建
      if (session.get("forder")==null){
          //创建购物车并放入session
          session.put("forder",new Forder(new HashSet<Sorder>()));
      }
    //把商品信息转换为soder并且添加到购物车（判断是否商品重复）
        Forder forder=(Forder)session.get("forder");
        forder= sorderService.addSorder(product,forder);
    //计算购物总价
        forder.setTotal(forderService.cluTotal(forder));
    //把新的购物车存到session
        session.put("forder",forder);
        return "showCar";
    }
    //根据商品编号更新商品的数量
    public String updateSorder(){
        //获取session中的购物车
        Forder forder=(Forder) session.get("forder");
        //更新购物车的数量
        forder=sorderService.updateSorder(model,forder);
        //计算总价格并把总价格放回购物车
        forder.setTotal(forderService.cluTotal(forder));
        //把购物车放回session
        session.put("forder",forder);
        //通过stream返回总价格
        inputStream=new ByteArrayInputStream(forder.getTotal().toString().getBytes());
        return "Stream";
    }
    public String querySale(){
        List<Object> list=sorderService.querySale(model.getNumber());
        ActionContext.getContext().getValueStack().push(list);
        return "jsonList";
    }
    public String getSorderDetail() throws Exception{
        List<Sorder> list= sorderService.querSorderByfid(model.getForder().getId());
        Forder forder=forderService.get(model.getForder().getId());
        String name=forder.getAddress().getName();
        String phone=forder.getAddress().getPhone();
        String addressname=forder.getAddress().getAddressname();

        if(forder.getPost().equals("0")) {
            session.put("kdstate", "未发货");
            session.put("kdtracelist", null);
            session.put("kdLogisticCode", null);
            session.put("ordercode", forder.getId());
        }else {
            KuaiDiBack kuaiDiBack = kuaiDiService.getOrderTracesByJson("ZTO", forder.getPost());
            if (kuaiDiBack.getSuccess().equals("true") && kuaiDiBack.getReason().equals("no")) {
                session.put("kdstate", kuaiDiBack.getState());
                session.put("kdtracelist", kuaiDiBack.getTraces());
                session.put("kdLogisticCode", kuaiDiBack.getLogisticCode());
                session.put("ordercode", forder.getId());
            } else {
                session.put("kdstate", null);
                session.put("kdtracelist", null);
                session.put("kdLogisticCode", null);
                session.put("ordercode", null);
            }
        }
        session.put("forderdetaillist",list);
        session.put("addressname",name);
        session.put("addressphone",phone);
        session.put("addressadname",addressname);
        return "forderdetail";
    }

}
