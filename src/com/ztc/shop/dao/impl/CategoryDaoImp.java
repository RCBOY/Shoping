package com.ztc.shop.dao.impl;

import com.ztc.shop.dao.CategoryDao;
import com.ztc.shop.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description：书写Category模块自身的业务逻辑
 * Created by ZTCJoe on 2016/9/14.
 */
@SuppressWarnings("unchecked")
@Repository("categoryDao")
public class CategoryDaoImp extends BaseDaoImp<Category> implements CategoryDao{
    public CategoryDaoImp(){
        super();
    }

    //通过类别级联查询Account
    @Override
    public List<Category> queryJoinAccount(String type,int page,int size) {
       return getSession().createQuery("FROM Category c left join fetch c.account where c.type like :type")
                .setString("type","%"+type+"%")
               .setFirstResult((page-1)*size)
               .setMaxResults(size)
                .list();
    }

    //根据关键字查询总记录数
    @Override
    public Long getCategoryCountbyType(String type) {
        return (Long) getSession().createQuery("select count(c) FROM Category c where c.type like :type")
                .setString("type","%"+type+"%")
                .uniqueResult();
    }

    @Override
    public void deleteByIds(String ids) {
        String hql="DELETE FROM Category WHERE id in "+"("+ids+")";
        getSession().createQuery(hql)
                .executeUpdate();
    }

    @Override
    public List<Category> queryByhot(boolean hot) {
        String hql="FROM Category c JOIN FETCH c.account WHERE c.hot=:hot";
       return getSession().createQuery(hql)
                .setBoolean("hot",true)
                .list();
    }
}
