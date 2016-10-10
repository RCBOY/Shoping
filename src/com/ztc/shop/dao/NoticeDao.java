package com.ztc.shop.dao;

import com.ztc.shop.model.Notice;
import net.sf.ehcache.search.expression.Not;

import java.util.List;

public interface NoticeDao extends BaseDao<Notice>{
    public List<Notice> querAllNotic(int maxnum);
}
