package com.mycompany.refactos_pizza.factory;

import com.mycompany.refactos_pizza.Enums.Size;

public class MediumPizza extends Pizza{

    public MediumPizza(String name, String description) {
        super(name, description, 15.0, Size.PizzaSize.MEDIUM);
    }

    @Override
    public String toString() {
        return "MediumPizza{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
