package com.ztc.shop.unit;

import com.ztc.shop.model.Notice;
import com.ztc.shop.service.NoticeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/9.
 */
@Component("noticeTimerTask")
public class NoticeTimerTaskUntil extends TimerTask {
    @Resource
    private NoticeService noticeService=null;
    private ServletContext appliction=null;
    public void setAppliction(ServletContext appliction) {
        this.appliction = appliction;
    }

    @Override
    public void run() {
       List<Notice> list= new ArrayList<>();
        for (Notice notice:noticeService.querAllNotic(5)){
            list.add(notice);
            System.out.println(notice);
        }
        appliction.setAttribute("noticeList",list);
    }
}
