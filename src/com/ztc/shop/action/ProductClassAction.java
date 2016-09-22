package com.ztc.shop.action;


import com.ztc.shop.model.Category;
import com.ztc.shop.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Description：做转发
 * Created by ZTCJoe on 2016/9/14.
 */
@Controller
@Scope("prototype")
public class ProductClassAction extends BaseAction<Product> {
    public ProductClassAction() {
    }
    public String   queryJoinCategory(){
        pageMap =new HashMap<String,Object>();
        List<Product> list=productService.queryJoinCategory(model.getName(),page,rows);
        //查询总记录数
       Long count=productService.getProductCountbyName(model.getName());
        pageMap.put("rows",list);
        pageMap.put("total",count);
        return "JsonProductDataMap";
    }
}
