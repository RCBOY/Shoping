package com.ztc.shop.model;

import java.io.Serializable;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/26.
 */
public class Color implements Serializable {
    private static final long serialVersionUID = 3427289459143302210L;
    private int id;
    private String colorname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        if (id != color.id) return false;
        if (colorname != null ? !colorname.equals(color.colorname) : color.colorname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (colorname != null ? colorname.hashCode() : 0);
        return result;
    }
}
