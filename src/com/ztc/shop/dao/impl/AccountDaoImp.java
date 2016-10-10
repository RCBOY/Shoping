package com.ztc.shop.dao.impl;

import com.ztc.shop.dao.AccountDao;
import com.ztc.shop.model.Account;
import com.ztc.shop.model.User;
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

    @Override
    public Account login(Account accout) {
        String hql="FROM Account a WHERE a.login=:login AND a.pass=:pass";
        return  (Account) getSession().createQuery(hql)
                .setString("login",accout.getLogin())
                .setString("pass",accout.getPass())
                .uniqueResult();
    }
}
