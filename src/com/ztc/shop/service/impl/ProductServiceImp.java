package com.ztc.shop.service.impl;

import com.ztc.shop.model.PageBean;
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
        return productDao.queryJoinCategory(name,page,size);
    }

    public void deleteByIds(String ids) {
        productDao.deleteByIds(ids);
    }

    @Override
    public Long getProductCountbyName(String type) {
        return productDao.getProductCountbyName(type);
    }

    @Override
    public List<Product> queryByHotCid(int cid) {
        return productDao.queryByHotCid(cid);
    }

    public List<Product> queryByStar(int num,int count){
        return productDao.queryByStar(num,count);
    }
    public List<Product> queryByTime(int first,int count){
        return productDao.queryByTime(first,count);
    }

    @Override
    public PageBean queryForPage(int cid,int pageSize, int curPage) {
        String hql="From Product p WHERE p.category.id="+cid;
        int allRows=productDao.getAllRowCount(hql);
        int totalPage=PageBean.countTotalPage(pageSize,allRows);
        int offest=PageBean.countOffestPage(pageSize,curPage);
        final int length=pageSize;
        final int currentPage=PageBean.countCurrentPage(curPage);
        List list=productDao.queryForPsage(hql,offest,length);
        PageBean pageBean=new PageBean();
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(list);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalPage(totalPage);
        pageBean.init();
        return pageBean;
    }
}
