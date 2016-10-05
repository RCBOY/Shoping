package com.ztc.shop.service.impl;

import com.ztc.shop.model.Address;
import com.ztc.shop.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/1.
 */
@SuppressWarnings("unchecked")
@Service("addressService")
public class AddressServiceImp extends BaseServiceImp<Address> implements AddressService {
    @Override
    public List<Address> getAddressByUid(int uid) {
        String hql="FROM Address a LEFT JOIN FETCH a.user WHERE a.user=:uid";
        return  getSession().createQuery(hql)
                .setInteger("uid",uid)
                .list();
    }
}
