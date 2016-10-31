package com.ztc.shop.action;

import com.ztc.shop.model.Address;
import com.ztc.shop.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/30.
 */
@Controller
@Scope("prototype")
public class UserClassAction extends BaseAction<User> {
    private  String code;
    private String oldpass;
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

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
    public String newUser(){
            String code="";
            //获取model，将model存入session中等待验证通过后使用
            System.out.println(model.getLogin()+model.getName()+model.getPhone());
            session.put("newUser",model);
            //生成一个4位数的随机验证码
            code= messageCodeUtil.getRodamCode(4);
            System.out.println(code);
            //存入session中
            session.put("code",code);
            //发送验证信息至邮箱
            String message="您在SimpleOne注册新账户的验证码为："+code+"。欢迎您的到来！【来自SimpleOne】";
            emailUtil.sendEmail(model.getEmail(),message);
            session.put("message","邮件发送成功");
            return "userComfir";
    }
    public String forComfirUser(){
        if (code.equals(session.get("code"))){
            userService.save((User) session.get("newUser"));
            session.put("user",session.get("newUser"));
            session.put("message","恭喜您注册成功");
            session.remove("newUser");
            return "success";
        }else {
            session.put("message","邮件验证码错误");
            return "userComfir";
        }
    }
    public String quitUser(){
        //User user=(User) session.get("user");
        //if (user.equals(null)){
        //    return "index";
        //}else{
            session.remove("user");
            return "index";
        //}
    }
    public String modifyUser(){
        try{
            String ok="SUCCESS";
            User user=(User) session.get("user");
            user.setEmail(model.getEmail());
            user.setPhone(model.getPhone());
            user.setSex(model.getSex());
            user.setName(model.getName());
            userService.update(user);
            inputStream=new ByteArrayInputStream(ok.getBytes());
        }catch (Exception e){
            //e.printStackTrace();
            session.put("error","修改信息出错");
            return "error";
        }
        return "Stream";
    }
    public String modifyPass(){
        String ok="success";
        String no="old pass wrong";
        try{
            User user=(User) session.get("user");
            String pass=user.getPass();
        if (oldpass.equals(pass)){
            user.setPass(model.getPass());
            userService.update(user);
            inputStream=new ByteArrayInputStream(ok.getBytes());
        }else {
            inputStream=new ByteArrayInputStream(no.getBytes());
        }

        }catch (Exception e){
            session.put("error","修改密码出错");
            return "error";
        }
            return "Stream";
    }
}
