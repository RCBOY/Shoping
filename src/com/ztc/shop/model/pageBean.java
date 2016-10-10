package com.ztc.shop.model;

import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Description：封装了分页信息的model类
 * Created by ZTCJoe on 2016/10/9.
 */
public class PageBean {
    java.util.List<Product> list; //要返回的某一页的记录列表

    private int allRows;//返回的总记录数
    private int totalPage; //记录总页数
    private int currentPage;//记录当前页
    private int pageSize;//记录每夜记录的数量

    private boolean isFirstPage;   //是否为第一页
    private boolean isLastPage;    //是否为最后一页
    private boolean isPreviousPage;//是否为上一页
    private boolean isNextPage;      //是否为下一页



    public int getAllRows() {
        return allRows;
    }

    public void setAllRows(int allRows) {
        this.allRows = allRows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public java.util.List getList() {
        return list;
    }

    public void setList(java.util.List list) {
        this.list = list;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    /**
     * 初始化分页信息
     */
    public void init(){
        this.isFirstPage=isFirstPage;
        this.isLastPage=isLastPage;
        this.isPreviousPage=isPreviousPage;
        this.isNextPage=isNextPage;
    }

    /**
     * 以下判断页的信息
     * @return
     */
    public boolean isFirstPage() {
        return currentPage == 1;            // 如是当前页是第1页
    }
    public boolean isLastPage() {
        return currentPage == totalPage;    //如果当前页是最后一页
    }
    public boolean isHasPreviousPage() {
        return currentPage != 1;             //只要当前页不是第1页
    }
    public boolean isHasNextPage() {
        return currentPage != totalPage;    //只要当前页不是最后1页
    }

    /**
     * 计算总的页数
     * @param pageSize 每页的大小
     * @param allRows  总的记录数
     * @return 总的页数
     */
    public static int countTotalPage(final int pageSize,final int allRows){
       final int totalPage=allRows%pageSize==0?allRows/pageSize:allRows/pageSize+1;
        return totalPage;
    }

    /**
     * 计算当前页要开始的记录数
     * @param pageSize  每页大小
     * @param currentPage   总的记录数
     * @return  当前页开始记录号
     */
    public static int countOffestPage(final int pageSize,final int currentPage){
        final int offest=pageSize*(currentPage-1);
        return offest;
    }

    /**
     *  计算当前页,若为0或者请求的URL中没有"?page=",则用1代替
     * @param page page 传入的参数(可能为空,即0,则返回1)
     * @return 当前页
     */
    public static int countCurrentPage(int page){
        final int curPage=(page==0?1:page);
        return curPage;
    }
}
