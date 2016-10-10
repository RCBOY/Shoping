package com.ztc.shop.dao;

import com.ztc.shop.model.Product;
import org.jboss.logging.Param;

import java.util.List;

public interface ProductDao extends BaseDao<Product> {
    //查询类别信息，并且级联管理员
    public List<Product> queryJoinCategory(String name, int page, int size);
    //根据关键字查询总记录数
    public  Long getProductCountbyName(String name);
    //根据ids删除多条类别
    public void deleteByIds(String ids);
    //根据热点类别查询当前类别的推荐商品（前四个，倒叙）
    public List<Product> queryByHotCid(int cid);

    /**
     * 根据推荐度（star）查询出商品（前五个）
     * @param num 要查询的商品有几颗心以上
     * @param count 每次查询的数量
     * @return 商品列表
     */
    public  List<Product> queryByStar(int num,int count);

    /**
     *根据上架时间查询
     * @param first 开始查询的数字
     * @param count  每次查询数量
     * @return 商品列表
     */
    public List<Product> queryByTime(int first,int count);

    /**
     * 分页查询
     * @param hql 要查询的hql语句
     * @param offest 开始查询的数字
     * @param length  每次查询数量
     * @return  商品列表
     */
    public List<Product> queryForPsage(final String hql,final int offest,final int length);

    /**
     * 查询总记录数
     * @param hql 需要的hql
     * @return
     */
    public int getAllRowCount(String hql);
}
