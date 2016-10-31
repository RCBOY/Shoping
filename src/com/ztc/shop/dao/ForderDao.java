package com.ztc.shop.dao;

import com.ztc.shop.model.Forder;

import java.util.List;


public interface ForderDao extends BaseDao<Forder> {
////    计算购物车总价格
//   public double cluTotal(Forder forder);
//    根据订单订单编号
    public void updateStatusById(int id, int sid);
    public List<Forder> queryByid(int id);
    public Forder getByfid(int fid);
    public List<Forder> getByUidAndSid(int uid,String sid);
}
