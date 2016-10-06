package com.ztc.shop.dao;

import com.ztc.shop.model.Address;

import java.util.List;

@SuppressWarnings("unchecked")
public interface AddressDao extends BaseDao<Address> {
    public List<Address> getAddressByUid(int uid);
}
