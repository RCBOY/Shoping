package com.ztc.shop.SSHTest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.FileInputStream;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/19.
 */
public class TestSoap {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient= new HttpClient();
        PostMethod postMethod=new PostMethod("http://WebXml.com.cn/getMobileCodeInfo/WebServices/MobileCodeWS.asmx");

        postMethod.setRequestHeader("Content-Type","text/xml; charset=utf-8");
        postMethod.setRequestBody(new FileInputStream("C:/a.txt"));
        int code=httpClient.executeMethod(postMethod);
        System.out.println("消息码为:" + code);
        System.out.println("返回的消息为:" + postMethod.getResponseBodyAsString());
        postMethod.releaseConnection();
    }
}
