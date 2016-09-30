package com.ztc.shop.service;

import com.ztc.shop.model.Forder;
import com.ztc.shop.model.Product;
import com.ztc.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {
    //添加购物项方法
    public Forder addSorder(Product product,Forder forder);
//    把商品数据转换为sorder
    public  Sorder productToSorder(Product product);
}
