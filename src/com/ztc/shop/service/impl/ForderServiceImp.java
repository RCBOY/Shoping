package com.ztc.shop.service.impl;

import com.ztc.shop.model.Forder;
import com.ztc.shop.model.Sorder;
import com.ztc.shop.service.ForderService;
import org.springframework.stereotype.Service;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/28.
 */
@Service("forderService")
public class ForderServiceImp extends BaseServiceImp<Forder> implements ForderService {
    @Override
    public double cluTotal(Forder forder) {
        double total=0.0;
        for (Sorder temp:forder.getSorderSet()){
           total += temp.getNumber()*temp.getPrice();
        }
        return total;
    }
}