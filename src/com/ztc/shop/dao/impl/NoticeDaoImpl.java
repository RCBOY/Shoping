package com.ztc.shop.dao.impl;

import com.ztc.shop.dao.NoticeDao;
import com.ztc.shop.model.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/9.
 */
@SuppressWarnings("unchecked")
@Repository("noticeDao")
public class NoticeDaoImpl extends BaseDaoImp<Notice> implements NoticeDao {
    @Override
    public List<Notice> querAllNotic(int maxnum) {
        String hql="FROM Notice n JOIN FETCH n.account ORDER BY n.date DESC ";
        return getSession().createQuery(hql)
                .setFirstResult(0)
                .setMaxResults(maxnum)
                .list();
    }
}
