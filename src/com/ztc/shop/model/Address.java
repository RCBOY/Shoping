package com.ztc.shop.model;

import java.io.Serializable;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/28.
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 495390719613139772L;
    private Integer id;
    private User user;
    private String name;
    private String phone;
    private String addressname;
    public Address(){

    }
    public Address(int id){
        this.id=id;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (user != null ? !user.equals(address.user) : address.user != null) return false;
        if (name != null ? !name.equals(address.name) : address.name != null) return false;
        if (phone != null ? !phone.equals(address.phone) : address.phone != null) return false;
        if (addressname != null ? !addressname.equals(address.addressname) : address.addressname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (addressname != null ? addressname.hashCode() : 0);
        return result;
    }
}
