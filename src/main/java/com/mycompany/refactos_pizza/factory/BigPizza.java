package com.mycompany.refactos_pizza.factory;

import com.mycompany.refactos_pizza.Enums.Size;

public class BigPizza extends Pizza{

    public BigPizza(String name, String description) {
        super(name, description, 20.0, Size.PizzaSize.BIG);
    }

    @Override
    public String toString() {
        return "BigPizza{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
