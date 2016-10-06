package com.ztc.shop.service.impl;

import com.ztc.shop.model.User;
import com.ztc.shop.service.BaseService;
import com.ztc.shop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/30.
 */@Service("userService")
public class UserServiceImp extends BaseServiceImp<User> implements UserService {
    @Override
    public User login(User user) {
        //String hql="FROM User u WHERE u.login=:login AND u.pass=:pass";
        //return  (User) getSession().createQuery(hql)
        //        .setString("login",user.getLogin())
        //        .setString("pass",user.getPass())
        //        .uniqueResult();
        return userDao.login(user);
    }
}
