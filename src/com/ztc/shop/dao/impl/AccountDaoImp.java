package com.ztc.shop.dao.impl;

import com.ztc.shop.dao.AccountDao;
import com.ztc.shop.model.Account;
import org.springframework.stereotype.Repository;

/**
 * Description：用于书写Account模块自身的业务逻辑
 * Created by ZTCJoe on 2016/9/14.
 */
@SuppressWarnings("unchecked")
@Repository("accountDao")
public class AccountDaoImp extends BaseDaoImp<Account> implements AccountDao{
    public AccountDaoImp(){
        super();
    }
}
