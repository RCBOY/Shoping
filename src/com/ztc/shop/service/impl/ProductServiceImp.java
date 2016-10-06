package com.ztc.shop.service.impl;

import com.ztc.shop.model.Product;
import com.ztc.shop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：书写Product模块自身的业务逻辑
 * Created by ZTCJoe on 2016/9/14.
 */
@SuppressWarnings("unchecked")
@Service("productService")
public class ProductServiceImp extends BaseServiceImp<Product> implements ProductService{
    public ProductServiceImp(){
        super();
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public List<Product> queryJoinCategory(String name, int page, int size) {
           //return getSession().createQuery("FROM Product p left join fetch p.category where p.name like :name")
           //     .setString("name","%"+name+"%")
           //     .setFirstResult((page-1)*size)
           //     .setMaxResults(size)
           //     .list();
        return productDao.queryJoinCategory(name,page,size);
    }
    public void deleteByIds(String ids) {
        //String hql="DELETE FROM Product WHERE id in "+"("+ids+")";
        //getSession().createQuery(hql)
        //        .executeUpdate();
        productDao.deleteByIds(ids);
    }

    @Override
    public Long getProductCountbyName(String type) {
        //return (Long) getSession().createQuery("select count(p) FROM Product p where p.name like :name")
        //        .setString("name","%"+type+"%")
        //        .uniqueResult();
        return productDao.getProductCountbyName(type);
    }

    @Override
    public List<Product> queryByHotCid(int cid) {
        //String hql="FROM Product p JOIN FETCH p.category WHERE p.commend=true AND p.open=true AND p.category.id=:cid ORDER BY p.date DESC";
        //return getSession().createQuery(hql)//
        //       .setInteger("cid",cid)//
        //        .setFirstResult(0)//
        //        .setMaxResults(3)//
        //        .list();
        return productDao.queryByHotCid(cid);
    }

}
