package com.ztc.shop.service;

import com.ztc.shop.model.Notice;

import java.util.List;

public interface NoticeService extends BaseService<Notice> {
    public List<Notice> querAllNotic(int maxnum);
}
