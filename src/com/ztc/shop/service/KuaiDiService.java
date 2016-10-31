package com.ztc.shop.service;

import com.ztc.shop.model.KuaiDiBack;

public interface KuaiDiService {
    public KuaiDiBack getOrderTracesByJson(String expCode, String expNo)throws Exception;
}
