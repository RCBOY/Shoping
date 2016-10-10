package com.ztc.shop.service.impl;

import com.ztc.shop.model.Notice;
import com.ztc.shop.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/9.
 */
@SuppressWarnings("unchecked")
@Service("noticeService")
public class NoticeServiceImp extends BaseServiceImp<Notice> implements NoticeService {
    @Override
    public List<Notice> querAllNotic(int maxnum) {
        return noticeDao.querAllNotic(maxnum);
    }
}
