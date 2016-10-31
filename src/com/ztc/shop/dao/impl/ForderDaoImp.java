package com.ztc.shop.dao.impl;

import com.ztc.shop.dao.ForderDao;
import com.ztc.shop.model.Forder;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<Forder> queryByid(int id){
        String hql="From Forder f LEFT JOIN fetch f.status where f.user=:uid order by f.date DESC ";
        return getSession().createQuery(hql)
                .setInteger("uid",id)
                .setFirstResult(0)
                .setMaxResults(20)
                .list();
    }
    public Forder getByfid(int fid){
        String hql="From Forder f left join fetch f.address where f.id=:fid";
        return(Forder) getSession().createQuery(hql)
                .setInteger("fid",fid)
                .uniqueResult();
    }
    public List<Forder> getByUidAndSid(int uid,String sid){
        String hql="From Forder f LEFT JOIN fetch f.status where f.user=:uid AND f.status=:status order by f.date DESC ";
        return getSession().createQuery(hql)
                .setInteger("uid",uid)
                .setString("status",sid)
                .setFirstResult(0)
                .setMaxResults(20)
                .list();
    }
}
