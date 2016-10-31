package com.ztc.shop.SSHTest;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/19.
 */
@WebService
public class TestWsdl {
    public @WebResult(name = "result") String HelloWord(@WebParam(name = "name") String s){
        return s;
    }

    public static void main(String[] args) {
        String address="http://172.22.82.42:9999/ws";
        Endpoint.publish(address,new TestWsdl());
        System.out.println(address+"?wsdl");

    }
}
