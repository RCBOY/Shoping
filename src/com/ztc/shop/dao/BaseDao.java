package com.ztc.shop.dao;


import java.util.List;

public interface BaseDao<T> {
    void save(T t);
    public void update(T t);
    public void delete(int id);
    public T get(int id);
    public List<T> query();
}
