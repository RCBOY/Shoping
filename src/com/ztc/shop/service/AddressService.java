package com.ztc.shop.service;

import com.ztc.shop.model.Address;

import java.util.List;
@SuppressWarnings("unchecked")
public interface AddressService extends BaseService<Address> {
    public List<Address> getAddressByUid(int uid);
}
