package com.mycompany.refactos_pizza.model;

import com.mycompany.refactos_pizza.Enums.Size;

public class DrinkOrder extends DrinkItem{

    private Size.DrinkSize size;

    public DrinkOrder(String name, String description, Double price, Size.DrinkSize size) {
        super(name, description, price);
        this.size = size;
    }

    public Size.DrinkSize getSize() {
        return size;
    }
}
