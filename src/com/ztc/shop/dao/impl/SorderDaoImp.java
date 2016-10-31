package com.ztc.shop.dao.impl;

import com.ztc.shop.dao.SorderDao;
import com.ztc.shop.model.Sorder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/29.
 */
@SuppressWarnings("unchecked")
@Repository("sorderDao")
public class SorderDaoImp extends BaseDaoImp<Sorder> implements SorderDao {

    @Override
    public List<Object> querySale(int number) {
        String hql="SELECT s.name, sum(s.number)FROM Sorder s JOIN s.product GROUP BY s.product.id ORDER BY sum(s.number) DESC ";
        return getSession().createQuery(hql)
                .setFirstResult(0)
                .setMaxResults(number)
                .list();
    }
    public List<Sorder> querSorderByfid(int fid){
        String hql="FROM Sorder s LEFT JOIN FETCH s.product WHERE s.forder=:fid";
       return getSession().createQuery(hql)
                .setInteger("fid",fid)
                .setFirstResult(0)
                .setMaxResults(15)
                .list();
    }

}
