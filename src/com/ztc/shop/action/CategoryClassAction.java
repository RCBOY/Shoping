package com.ztc.shop.action;


import com.ztc.shop.model.Category;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import java.io.ByteArrayInputStream;
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
        List<Category> list=categoryService.queryJoinAccount(model.getType(),page,rows);
        //查询总记录数
        Long count= categoryService.getCategoryCountbyType(model.getType());
        pageMap.put("rows",list);
        pageMap.put("total",count);
        return "JsonDataMap";
    }
    public String deleteByIds(){
        categoryService.deleteByIds(ids);
        inputStream =new ByteArrayInputStream("true".getBytes());
        return "Stream";
    }
    public String save(){
        categoryService.save(model);
        inputStream =new ByteArrayInputStream("true".getBytes());
        return "Stream";
    }
    public String update(){
        categoryService.update(model);
        inputStream =new ByteArrayInputStream("true".getBytes());
        return "Stream";
    }
}
