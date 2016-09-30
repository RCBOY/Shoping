package com.ztc.shop.service.impl;

import com.ztc.shop.model.Account;
import com.ztc.shop.model.Category;
import com.ztc.shop.service.AccountService;
import com.ztc.shop.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * Description：用于书写Account模块自身的业务逻辑
 * Created by ZTCJoe on 2016/9/14.
 */
@SuppressWarnings("unchecked")
@Service("accountService")
public class AccountServiceImp extends BaseServiceImp<Account> implements AccountService{
    public AccountServiceImp(){
        super();
    }
}
