package com.mycompany.refactos_pizza.factory;

import com.mycompany.refactos_pizza.Enums.Size;

public class GiantDrink extends Drink{

    public GiantDrink(String name, String description) {
        super(name, description, 5.0, Size.DrinkSize.GIANT);
    }

    @Override
    public String toString() {
        return "GiantDrink{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
