package com.ztc.shop.action;

import com.ztc.shop.model.Forder;
import com.ztc.shop.model.Product;
import com.ztc.shop.model.Sorder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/28.
 */
@Controller
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
}
