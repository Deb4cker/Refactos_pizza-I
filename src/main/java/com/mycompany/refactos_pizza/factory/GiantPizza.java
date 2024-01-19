package com.mycompany.refactos_pizza.factory;

import com.mycompany.refactos_pizza.Enums.Size;

public class GiantPizza extends Pizza{

    public GiantPizza(String name, String description) {
        super(name, description, 25.0, Size.PizzaSize.GIANT);
    }

    @Override
    public String toString() {
        return "GiantPizza{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
