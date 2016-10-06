package com.ztc.shop.dao;

import com.ztc.shop.model.User;

public interface UserDao extends BaseDao<User> {
    public User login(User user);
}
