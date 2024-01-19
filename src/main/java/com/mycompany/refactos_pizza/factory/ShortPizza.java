package com.mycompany.refactos_pizza.factory;

import com.mycompany.refactos_pizza.Enums.Size;

public class ShortPizza extends Pizza{

    public ShortPizza(String name, String description) {
        super(name, description, 12.0, Size.PizzaSize.SMALL);
    }

    @Override
    public String toString() {
        return "ShortPizza{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
