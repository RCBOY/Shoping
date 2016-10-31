package com.ztc.shop.unit;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Description：短信发送工具类
 * Created by ZTCJoe on 2016/10/4.
 * HttpClent用于在java代码中发送http请求
 */
@Component("messageUtil")
public class MseeageUtilImp implements MessageUtil  {
    @Value("#{prop.messageKey}")
    private String messageKey="";
    @Value("#{prop.messageUid}")
    private String messageUid="";
    public void seadMessage(String number, String message) {
        //    打开浏览器（用于模拟发送http请求）
        HttpClient httpClient = new HttpClient();
        //    创建请求方式
        PostMethod postMethod = new PostMethod("http://utf8.sms.webchinese.cn/");
        //    设置请求参数
        postMethod.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
        postMethod.setParameter("uid", messageUid);
        postMethod.setParameter("key", messageKey);
        postMethod.setParameter("smsMob", number);
        postMethod.setParameter("smsText", message);
        //    提交请求
        int code;
        String result = null;
        try {
            code = httpClient.executeMethod(postMethod);
            System.out.println(code);
            //获取服务器返回的数据信息
            result = postMethod.getResponseBodyAsString();
            System.out.println("结果为" + result);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放连接
            postMethod.releaseConnection();
        }
    }
}

