package com.ztc.shop.service;

import com.ztc.shop.model.User;

public interface UserService extends BaseService<User> {
    public User login(User user);
}
