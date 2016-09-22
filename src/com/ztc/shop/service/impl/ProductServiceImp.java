package com.ztc.shop.service.impl;

import com.ztc.shop.model.Category;
import com.ztc.shop.model.Product;
import com.ztc.shop.service.CategoryService;
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
           return getSession().createQuery("FROM Product p left join fetch p.category where p.name like :name")
                .setString("name","%"+name+"%")
                .setFirstResult((page-1)*size)
                .setMaxResults(size)
                .list();
    }

    @Override
    public Long getProductCountbyName(String type) {
        return (Long) getSession().createQuery("select count(p) FROM Product p where p.name like :name")
                .setString("name","%"+type+"%")
                .uniqueResult();
    }

    @Override
    public void deleteByIds(String ids) {

    }
}
