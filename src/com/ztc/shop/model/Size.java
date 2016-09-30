package com.ztc.shop.model;

import java.io.Serializable;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/26.
 */
public class Size implements Serializable {
    private static final long serialVersionUID = -6702435676192560559L;
    private int id;
    private String sizename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSizename() {
        return sizename;
    }

    public void setSizename(String sizename) {
        this.sizename = sizename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Size size = (Size) o;

        if (id != size.id) return false;
        if (sizename != null ? !sizename.equals(size.sizename) : size.sizename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sizename != null ? sizename.hashCode() : 0);
        return result;
    }
}
