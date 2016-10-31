package com.ztc.shop.service.impl;

import com.ztc.shop.model.Forder;
import com.ztc.shop.model.Sorder;
import com.ztc.shop.service.ForderService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void updateStatusById(int id,int sid) {
        forderDao.updateStatusById(id,sid);
    }
    public List<Forder> queryByid(int id){
       return forderDao.queryByid(id);
    }
    public Forder getByfid(int fid){
        return  forderDao.getByfid(fid);
    }
    public List<Forder> getByUidAndSid(int uid,String sid){
        return forderDao.getByUidAndSid(uid,sid);
    }
}
