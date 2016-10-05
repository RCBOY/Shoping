package com.ztc.shop.action;

import com.ztc.shop.model.BackData;
import com.ztc.shop.model.Forder;
import com.ztc.shop.model.SendData;
import com.ztc.shop.model.User;
import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;
/**
 * Struts处理流程：获取请求以后，首先穿件Action代理，在创建代理的时候顺便创建了Action，执行18个拦截器，
 * 拦截器调用成功再调用Action的方法。
 *action的方法执行完毕后再执行18个拦截器
 * 创建Action--->servletConfig--->modelDriver
 */

/**
 * Description：支付方法的Action
 * Created by ZTCJoe on 2016/10/3.
 */
@Controller
@Scope("prototype")
public class PayClassAction extends BaseAction<Object> implements ParameterAware{
    private Map<String,String[]> parameters;

    //在这先执行servletConfig拦截器，在执行ModelDriver拦截器
    @Override
    public Object getModel() {
        if (parameters.get("pd_FrpId")!=null){
            model=new SendData();
        }else {
            model=new BackData();
        }
        return model;
    }

    @Override
    public void setParameters(Map<String, String[]> parameters) {
        this.parameters=parameters;
    }

    public String goBank(){
        SendData sendData=(SendData) model;
        //补全参数p2 p3 pd pa  要从session中获取
        Forder forder=(Forder) session.get("oldforder");
        User user=(User) session.get("user");
        sendData.setP2_Order(forder.getId().toString());
        sendData.setP3_Amt(forder.getTotal().toString());
        sendData.setPa_MP(user.getEmail()+","+user.getPhone());
        //对参数追加，加密获取签名，存储到request域（在saveDataToRequest中完成）
        payService.saveDataToRequest(request,sendData);
        //跳转页面
        return "pay";
    }
    public void backBank(){
        BackData backData=(BackData)model;
        System.out.println(backData);
        boolean isOk=payService.checkBackData(backData);
        if (isOk){
            //更新订单状态
            forderService.updateStatusById(Integer.parseInt(backData.getR6_Order()),2);
            //更具user的邮箱发送邮件
            String email= backData.getR8_MP().split(",")[0];
            emailUtil.sendEmail(email,backData.getR6_Order());
            //发送短信
            String phone= backData.getR8_MP().split(",")[1];
            emailUtil.sendEmail(phone,backData.getR6_Order());
            System.out.println("-----success----");
        }else {
            System.out.println("-----fail----");
        }
    }
}
