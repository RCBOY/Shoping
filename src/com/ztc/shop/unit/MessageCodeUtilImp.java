package com.ztc.shop.unit;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Description：用于短信邮件验证的验证码生成工具类
 * Created by ZTCJoe on 2016/10/10.
 */
@Component("messageCodeUtil")
public class MessageCodeUtilImp implements MessageCodeUtil {
    String code="1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
    String codeArr[]=code.split(",");
    Random random=new Random();
    int index=0;
    public String getRodamCode(int num){
        String newCode="";
        for (int i=0; i<num; ++i)
        {
            index = random.nextInt(codeArr.length-1);//在0到codeArr.length-1生成一个伪随机数赋值给index
            newCode += codeArr[index];//将对应索引的数组与newCode的变量值相连接
        }
        return newCode;
    }

}
