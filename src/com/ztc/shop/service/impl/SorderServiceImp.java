package com.ztc.shop.service.impl;

import com.ztc.shop.model.Forder;
import com.ztc.shop.model.Product;
import com.ztc.shop.model.Sorder;
import com.ztc.shop.service.SorderService;
import org.springframework.stereotype.Service;

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
}
