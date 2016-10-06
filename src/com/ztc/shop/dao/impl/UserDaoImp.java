package com.ztc.shop.dao.impl;

import com.ztc.shop.dao.UserDao;
import com.ztc.shop.model.User;
import org.springframework.stereotype.Repository;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/30.
 */
@Repository("userDao")
public class UserDaoImp extends BaseDaoImp<User> implements UserDao {
    @Override
    public User login(User user) {
        String hql="FROM User u WHERE u.login=:login AND u.pass=:pass";
        return  (User) getSession().createQuery(hql)
                .setString("login",user.getLogin())
                .setString("pass",user.getPass())
                .uniqueResult();
    }
}
