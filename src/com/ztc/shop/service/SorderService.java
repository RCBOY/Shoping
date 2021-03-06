package com.ztc.shop.service;

import com.ztc.shop.model.Forder;
import com.ztc.shop.model.Product;
import com.ztc.shop.model.Sorder;

import java.util.List;

public interface SorderService extends BaseService<Sorder> {
    //添加购物项方法
    public Forder addSorder(Product product,Forder forder);
//    把商品数据转换为sorder
    public  Sorder productToSorder(Product product);
//    根据id更新购物项数量
    public Forder updateSorder(Sorder sorder,Forder forder);
//    查询商品的销量
    public List<Object> querySale(int number);
    public List<Sorder> querSorderByfid(int fid);

}
