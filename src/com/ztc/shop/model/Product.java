package com.ztc.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/26.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -9164022382056082723L;
    private int id;
    private String name;
    private Double price;
    private Double newprice;
    private String pic;
    private String remark;
    private String xremark;
    private Timestamp date;
    private Boolean commend;
    private Boolean open;
    private Category category;
    private String size;
    private String color;
    private Integer discount;
    private Integer count;
    private Integer star;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Double getNewprice() {
        return newprice;
    }

    public void setNewprice(Double newprice) {
        this.newprice = newprice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getXremark() {
        return xremark;
    }

    public void setXremark(String xremark) {
        this.xremark = xremark;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Boolean getCommend() {
        return commend;
    }

    public void setCommend(Boolean commend) {
        this.commend = commend;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (pic != null ? !pic.equals(product.pic) : product.pic != null) return false;
        if (remark != null ? !remark.equals(product.remark) : product.remark != null) return false;
        if (xremark != null ? !xremark.equals(product.xremark) : product.xremark != null) return false;
        if (date != null ? !date.equals(product.date) : product.date != null) return false;
        if (commend != null ? !commend.equals(product.commend) : product.commend != null) return false;
        if (open != null ? !open.equals(product.open) : product.open != null) return false;
        if (category!= null ? !category.equals(product.category) : product.category != null) return false;
        if (size != null ? !size.equals(product.size) : product.size != null) return false;
        if (color != null ? !color.equals(product.color) : product.color != null) return false;
        if (count != null ? !count.equals(product.count) : product.count != null) return false;
        if (discount != null ? !discount.equals(product.discount) : product.discount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (xremark != null ? xremark.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (commend != null ? commend.hashCode() : 0);
        result = 31 * result + (open != null ? open.hashCode() : 0);
        result = 31 * result + (category!= null ? category.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", remark='" + remark + '\'' +
                ", xremark='" + xremark + '\'' +
                ", date='" + date + '\'' +
                ", commend='" + commend+ '\'' +
                ", open='" + open+ '\'' +
                ", size='" + size+ '\'' +
                ", color='" + color+ '\'' +
                ", count='" + count+ '\'' +
                ", discount='" + discount+ '\'' +
                ", dcategory='" + category+ '\'' +
                ", pic=" + pic +
                '}';
    }
}
