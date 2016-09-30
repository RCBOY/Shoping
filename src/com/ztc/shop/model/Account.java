package com.ztc.shop.model;

import java.io.Serializable;

/**
 * Description：
 * Created by ZTCJoe on 2016/9/15.
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 3675787486287448514L;
    private int id;
    private String login;
    private String name;
    private String pass;
    public Account(){

    }
    public Account(String login,String name,String pass){
        this.login=login;
        this.name=name;
        this.pass=pass;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (login != null ? !login.equals(account.login) : account.login != null) return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (pass != null ? !pass.equals(account.pass) : account.pass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }
}
