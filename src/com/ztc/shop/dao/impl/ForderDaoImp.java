package com.ztc.shop.dao.impl;

import com.ztc.shop.dao.ForderDao;
import com.ztc.shop.model.Forder;
import org.springframework.stereotype.Repository;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/28.
 */
@Repository("forderDao")
public class ForderDaoImp extends BaseDaoImp<Forder> implements ForderDao {
    //@Override
    //public double cluTotal(Forder forder) {
    //    double total=0.0;
    //    for (Sorder temp:forder.getSorderSet()){
    //       total += temp.getNumber()*temp.getPrice();
    //    }
    //    return total;
    //}

    @Override
    public void updateStatusById(int id,int sid) {
        String hql="UPDATE Forder f SET f.status=:sid WHERE f.id=:id";
        getSession().createQuery(hql)
                .setInteger("sid",sid)
                .setInteger("id",id)
                .executeUpdate();
    }
}
