package com.ztc.shop.model;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/13.
 */
public class Wish {
    private int id;
    private User uid;
    private Product pid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public Product getPid() {
        return pid;
    }

    public void setPid(Product pid) {
        this.pid = pid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wish wish = (Wish) o;

        if (id != wish.id) return false;
        if (uid != null ? !uid.equals(wish.uid) : wish.uid != null) return false;
        if (pid != null ? !pid.equals(wish.pid) : wish.pid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        return result;
    }
}
