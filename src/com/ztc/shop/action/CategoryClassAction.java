package com.ztc.shop.action;


import com.ztc.shop.model.Category;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：做转发
 * Created by ZTCJoe on 2016/9/14.
 */
@Controller
@Scope("prototype")
public class CategoryClassAction extends BaseAction<Category> {
    public CategoryClassAction() {
    }
    public String   queryJoinAccount(){
        pageMap =new HashMap<String,Object>();
        List<Category> list=categoryService.queryJoinAccount(model.getType(),page,size);
        //查询总记录数
       Long count= categoryService.getCategoryCountbyType(model.getType());
        pageMap.put("categoryList",list);
        pageMap.put("total",count);
        return "JsonDataMap";
    }

}
