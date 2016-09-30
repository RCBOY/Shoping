package com.ztc.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/28.
 */
public class Sorder implements Serializable {
    private static final long serialVersionUID = 6882479691209033429L;
    private int id;
    private String name;
    private Double price;
    private Integer number;
    private Product product;
    private Forder forder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Forder getForder() {
        return forder;
    }

    public void setForder(Forder forder) {
        this.forder = forder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sorder sorder = (Sorder) o;

        if (id != sorder.id) return false;
        if (number != sorder.number) return false;
        if (name != null ? !name.equals(sorder.name) : sorder.name != null) return false;
        if (price != null ? !price.equals(sorder.price) : sorder.price != null) return false;
        if (product != null ? !product.equals(sorder.product) : sorder.product != null) return false;
        if (forder != null ? !forder.equals(sorder.forder) : sorder.forder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (forder != null ? forder.hashCode() : 0);
        return result;
    }
}
