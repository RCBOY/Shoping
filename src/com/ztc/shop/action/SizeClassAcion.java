package com.ztc.shop.action;

import com.ztc.shop.model.Size;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/26.
 */
@Controller
@Scope("prototype")
public class SizeClassAcion extends BaseAction<Size> {
    public String query(){
        jsonList =new ArrayList<Size>();
        jsonList=sizeService.query();
        return "jsonDataList";
    }
}
