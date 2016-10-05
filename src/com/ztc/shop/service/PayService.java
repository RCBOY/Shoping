package com.ztc.shop.service;

import com.ztc.shop.model.BackData;
import com.ztc.shop.model.SendData;

import java.util.Map;
@SuppressWarnings("unchecked")
public interface PayService {
    public  Map<String, Object> saveDataToRequest(Map<String, Object> request, SendData sendData);
    public boolean checkBackData(BackData backData);
}
