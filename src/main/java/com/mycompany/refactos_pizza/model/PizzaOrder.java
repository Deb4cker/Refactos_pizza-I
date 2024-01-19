package com.mycompany.refactos_pizza.model;

import com.mycompany.refactos_pizza.Enums.Size;

public class PizzaOrder extends PizzaItem{

    private Size.PizzaSize size;
    
    public PizzaOrder(String name, String description, Double price, Size.PizzaSize size) {
        super(name, description, price * size.priceFactor);
        this.size = size;
    }

    public Size.PizzaSize getSize() {
        return size;
    }

    public void setSize(Size.PizzaSize size) {
        this.size = size;
    }
}
