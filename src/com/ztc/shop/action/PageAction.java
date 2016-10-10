package com.ztc.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ztc.shop.model.PageBean;
import com.ztc.shop.model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Description：用于商品分类的Action
 * Created by ZTCJoe on 2016/10/9.
 */
@Controller
@Scope("prototype")
public class PageAction extends BaseAction<PageBean> {
    private int cid;
    private int page;           //第几页
    private PageBean pageBean;  //包含分布信息的bean

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPage() {
        return page;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String queryProductForPage(){
            this.pageBean=productService.queryForPage(cid,9,page);
            List<Product> categoryList=pageBean.getList();
            session.put("categoryProductList",categoryList);
            session.put("pageBean",pageBean);
            return "category";
    }

}
