package com.ztc.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description：当对象存储到硬盘的时候，就需要实现序列化接口，序列化的功能就是添加了一个为唯一的ID（类主键）
 * 这样在反序列化的时候就可以成功找到相应的对象。
 * 容器的关闭ubingbuhui导致session的关闭
 * Created by ZTCJoe on 2016/9/28.
 */
public class Forder implements java.io.Serializable{
    private static final long serialVersionUID = 3139431141583104591L;
    private Integer id;
    private String remark;
    private Timestamp date;
    private Double total;
    private String post;
    private Address address;
    private Status status;
    private User user;
    private Set<Sorder> sorderSet;

    public Forder(){

    }

    public Forder(Set<Sorder> sorderSet){
        this.sorderSet=sorderSet;
    }

    public Set<Sorder> getSorderSet() {
        return sorderSet;
    }

    public void setSorderSet(Set<Sorder> sorders) {
        this.sorderSet = sorders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forder forder = (Forder) o;

        if (id != forder.id) return false;
        if (remark != null ? !remark.equals(forder.remark) : forder.remark != null) return false;
        if (date != null ? !date.equals(forder.date) : forder.date != null) return false;
        if (total != null ? !total.equals(forder.total) : forder.total != null) return false;
        if (post != null ? !post.equals(forder.post) : forder.post != null) return false;
        if (address != null ? !address.equals(forder.address) : forder.address != null) return false;
        if (user != null ? !user.equals(forder.user) : forder.user != null) return false;
        if (status != null ? !status.equals(forder.status) : forder.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = id;
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return   "Forder [id="+id +"remark"+remark+"date"+date+"total"+total+"post"+post+"address"+address+"status"+status+"user"+user+"]";
    }
}
