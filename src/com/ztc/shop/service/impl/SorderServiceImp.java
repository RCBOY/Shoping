package com.ztc.shop.service.impl;

import com.ztc.shop.model.Forder;
import com.ztc.shop.model.Product;
import com.ztc.shop.model.Sorder;
import com.ztc.shop.service.SorderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/29.
 */
@SuppressWarnings("unchecked")
@Service("sorderService")
public class SorderServiceImp extends BaseServiceImp<Sorder> implements SorderService {
    @Override
    public Forder addSorder(Product product, Forder forder) {
        boolean isHave=false;
        Sorder sorder =productToSorder(product);
        //判断购物项是否重复

        for(Sorder old:forder.getSorderSet()){
            Integer id=old.getProduct().getId();
            if (id.equals(sorder.getProduct().getId())){
            //    重复只要添加数量就可以
                old.setNumber(old.getNumber()+sorder.getNumber());
                isHave=true;
                break;
            }
        }
        if (!isHave){
            // 建立购物项于购物车的关联,此时id为null但是入库时先入库购物车后入库购物项，那时就有主键
            sorder.setForder(forder);
            forder.getSorderSet().add(sorder);
    }
        return forder;
    }

    @Override
    public Sorder productToSorder(Product product) {
        Sorder sorder=new Sorder();
        sorder.setName(product.getName());
        sorder.setNumber(1);
        sorder.setPrice(product.getNewprice());
        sorder.setProduct(product);
        return sorder;
    }

    @Override
    public Forder updateSorder(Sorder sorder, Forder forder) {
        for (Sorder temp:forder.getSorderSet()){
            Integer id=temp.getProduct().getId();
            if (id.equals(sorder.getProduct().getId())){
                temp.setNumber(sorder.getNumber());
            }
        }
        return forder;
    }

    @Override
    public List<Object> querySale(int number) {
        return sorderDao.querySale(number);
    }
    public List<Sorder> querSorderByfid(int fid){
        return sorderDao.querSorderByfid(fid);
    }
}
