package com.ztc.shop.action;

import com.ztc.shop.model.Address;
import com.ztc.shop.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Set;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/30.
 */
@Controller
@Scope("prototype")
public class UserClassAction extends BaseAction<User> {
    public String login(){
    //    登入的判断
       model= userService.login(model);
        if (model==null){
            session.put("error","用户名或密码错误！");
            return "userLogin";
        }else {
            //    获得用户的uid
            int uid=model.getId();
            //    新建一个addressSet
            Set<Address> addresses=new HashSet<Address>();
            for (Address address:addressService.getAddressByUid(uid)){
                //    将地址放入addressSet中
                 addresses.add(address);
           }
            //    把集合放入user
            model.setAddressSet(addresses);
            //存储session
            session.put("user",model);
            //根据原url地址进行跳转
            if (session.get("url")==null){
                return "index";
            }else {
                return "url";
            }

        }
    }
}
