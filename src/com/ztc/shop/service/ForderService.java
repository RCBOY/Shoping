package com.ztc.shop.service;

import com.ztc.shop.model.Forder;
import org.springframework.stereotype.Service;


public interface ForderService extends BaseService<Forder> {
//    计算购物车总价格
   public double cluTotal(Forder forder);
//    根据订单订单编号
    public void updateStatusById(int id,int sid);
}
