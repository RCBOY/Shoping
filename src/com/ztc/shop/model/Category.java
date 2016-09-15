package com.ztc.shop.model;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/14.
 */
public class Category {
    private int id;
    private String type;
    private Boolean hot;

    public Category(){

    }
    public Category(String type,Boolean hot){
        this.type=type;
        this.hot=hot;
    }
    public Category(int id,String type,Boolean hot){
        this.id=id;
        this.type=type;
        this.hot=hot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (type != null ? !type.equals(category.type) : category.type != null) return false;
        if (hot != null ? !hot.equals(category.hot) : category.hot != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (hot != null ? hot.hashCode() : 0);
        return result;
    }
}
