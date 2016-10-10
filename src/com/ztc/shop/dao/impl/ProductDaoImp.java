package com.ztc.shop.dao.impl;

import com.ztc.shop.dao.ProductDao;
import com.ztc.shop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description：书写Product模块自身的业务逻辑
 * Created by ZTCJoe on 2016/9/14.
 */
@SuppressWarnings("unchecked")
@Repository("productDao")
public class ProductDaoImp extends BaseDaoImp<Product> implements ProductDao{
    public ProductDaoImp(){
        super();
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public List<Product> queryJoinCategory(String name, int page, int size) {
           return getSession().createQuery("FROM Product p left join fetch p.category where p.name like :name")
                .setString("name","%"+name+"%")
                .setFirstResult((page-1)*size)
                .setMaxResults(size)
                .list();
    }
    public void deleteByIds(String ids) {
        String hql="DELETE FROM Product WHERE id in "+"("+ids+")";
        getSession().createQuery(hql)
                .executeUpdate();
    }

    @Override
    public Long getProductCountbyName(String type) {
        return (Long) getSession().createQuery("select count(p) FROM Product p where p.name like :name")
                .setString("name","%"+type+"%")
                .uniqueResult();
    }

    @Override
    public List<Product> queryByHotCid(int cid) {
        String hql="FROM Product p JOIN FETCH p.category WHERE p.commend=true AND p.open=true AND p.category.id=:cid ORDER BY p.date DESC";
        return getSession().createQuery(hql)//
               .setInteger("cid",cid)//
                .setFirstResult(0)//
                .setMaxResults(3)//
                .list();
    }
    public List<Product> queryByStar(int num ,int count){
        String hql="FROM Product p JOIN FETCH p.category WHERE p.star>:num ORDER BY p.date DESC";
        return getSession().createQuery(hql)
                .setInteger("num",num)
                .setFirstResult(0)
                .setMaxResults(count)
                .list();
    }
    public List<Product> queryByTime(int first,int count){
        String hql="From Product p JOIN FETCH p.category ORDER BY p.date DESC";
        return getSession().createQuery(hql)
                .setFirstResult(first)
                .setMaxResults(count)
                .list();
    }

    @Override
    public List<Product> queryForPsage(String hql, int offest, int length) {
       return getSession().createQuery(hql)
                .setFirstResult(offest)
                .setMaxResults(length)
                .list();
    }

    @Override
    public int getAllRowCount(String hql) {
        return (int)getSession().createQuery(hql).list().size();
    }
}
