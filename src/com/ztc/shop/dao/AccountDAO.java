package com.ztc.shop.dao;

import com.ztc.shop.model.Account;

@SuppressWarnings("unchecked")
public interface AccountDao extends BaseDao<Account> {
    public Account login(Account accout);
}
