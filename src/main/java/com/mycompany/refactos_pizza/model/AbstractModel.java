package com.mycompany.refactos_pizza.model;

public class AbstractModel<T> {
    
    private long id;
    private static long serialId = 1L;
    
    public AbstractModel(){
        id = ++serialId;
    }

    public long getId() {
        return id;
    }
}
