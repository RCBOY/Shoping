package com.ztc.shop.action;

import com.ztc.shop.model.Color;
import com.ztc.shop.model.Size;
import com.ztc.shop.service.ColorService;
import com.ztc.shop.service.impl.ColorServiceImp;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/27.
 */
@Controller
@Scope("prototype")
public class ColorClassAction extends BaseAction<Color> {
    public String query(){
       jsonList=new ArrayList<Color>();
        jsonList=colorService.query();
        return "jsonDataList";
    }
}
