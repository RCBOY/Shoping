package com.ztc.shop.dao;

import com.ztc.shop.model.Account;
import com.ztc.shop.model.User;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
public interface AccountDao extends BaseDao<Account> {
    public Account login(Account accout);
}
