package com.mycompany.refactos_pizza.factory;

import com.mycompany.refactos_pizza.Enums.Size;

public class ShortDrink extends Drink{

    public ShortDrink(String name, String description) {
        super(name, description, 2.0, Size.DrinkSize.SMALL);
    }

    @Override
    public String toString() {
        return "ShortDrink{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
