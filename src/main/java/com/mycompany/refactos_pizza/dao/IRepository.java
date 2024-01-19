package com.mycompany.refactos_pizza.dao;

import com.mycompany.refactos_pizza.model.Item;
import java.util.ArrayList;
import java.util.List;


public interface IRepository<T> {
    
    static List<Item> drinks = new ArrayList<>();
    T getById(long id);
    
    void add(T obj);
    void remove(T obj);
}
