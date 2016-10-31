package com.ztc.shop.service.impl;

import com.ztc.shop.model.User;
import com.ztc.shop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/30.
 */@Service("userService")
public class UserServiceImp extends BaseServiceImp<User> implements UserService {
    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
