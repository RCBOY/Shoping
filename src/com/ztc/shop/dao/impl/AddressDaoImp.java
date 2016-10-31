package com.ztc.shop.dao.impl;

import com.ztc.shop.dao.AddressDao;
import com.ztc.shop.model.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/1.
 */
@SuppressWarnings("unchecked")
@Repository("addressDao")
public class AddressDaoImp extends BaseDaoImp<Address> implements AddressDao {
    @Override
    public List<Address> getAddressByUid(int uid) {
        String hql="FROM Address a LEFT JOIN fetch a.user WHERE a.user=:uid";
        return  getSession().createQuery(hql)
                .setInteger("uid",uid)
                .list();
    }
}
