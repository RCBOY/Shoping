package com.ztc.shop.model;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/30.
 */
public class Userstate {
    private int id;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userstate userstate = (Userstate) o;

        if (id != userstate.id) return false;
        if (state != null ? !state.equals(userstate.state) : userstate.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
