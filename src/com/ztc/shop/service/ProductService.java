package com.ztc.shop.service;

import com.ztc.shop.model.PageBean;
import com.ztc.shop.model.Product;

import java.util.List;

public interface ProductService extends BaseService<Product> {
    //查询类别信息，并且级联管理员
    public List<Product> queryJoinCategory(String name, int page, int size);
    //根据关键字查询总记录数
    public  Long getProductCountbyName(String name);
    //根据ids删除多条类别
    public void deleteByIds(String ids);
    //根据热点类别查询当前类别的推荐商品（前四个，倒叙）
    public List<Product> queryByHotCid(int cid);
    //根据推荐度（star）查询出商品（前五个,根据时间倒叙）
    public  List<Product> queryByStar(int num,int count);
    //根据上架时间查询商品
    public List<Product> queryByTime(int first,int count);

    /**
     * 分页查询
     * @param pageSize  页面大小
     * @param curPage   当前页
     * @param cid 需要查询商品的类别
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageBean queryForPage(int cid,int pageSize,int curPage);
}
