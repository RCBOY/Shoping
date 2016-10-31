package com.ztc.shop.dao;

import com.ztc.shop.model.Forder;
import com.ztc.shop.model.Product;
import com.ztc.shop.model.Sorder;

import java.util.List;

public interface SorderDao extends BaseDao<Sorder> {

//    查询商品的销量
    public List<Object> querySale(int number);
    public List<Sorder> querSorderByfid(int fid);
}
