package com.ztc.shop.dao;

import com.ztc.shop.model.Forder;


public interface ForderDao extends BaseDao<Forder> {
////    计算购物车总价格
//   public double cluTotal(Forder forder);
//    根据订单订单编号
    public void updateStatusById(int id, int sid);
}
