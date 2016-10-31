package com.ztc.shop.model;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Description：
 * Created by ZTCJoe on 2016/10/30.
 */
public class User {
    private int id;
    private String login;
    private String name;
    private String pass;
    private String phone;
    private String sex;
    private String email;
    private Userstate userstate;
    private Timestamp createtime;
    private String lastLogin;
    private Set<Address> addressSet;

    public User(){

    }
    public User(Set<Address> addresses){
        this.addressSet=addressSet;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Userstate getUserstate() {
        return userstate;
    }

    public void setUserstate(Userstate userstate) {
        this.userstate = userstate;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (pass != null ? !pass.equals(user.pass) : user.pass != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (userstate != null ? !userstate.equals(user.userstate) : user.userstate != null) return false;
        if (createtime != null ? !createtime.equals(user.createtime) : user.createtime != null) return false;
        if (lastLogin != null ? !lastLogin.equals(user.lastLogin) : user.lastLogin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userstate != null ? userstate.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        return result;
    }
}
