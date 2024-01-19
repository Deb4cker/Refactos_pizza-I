package com.mycompany.refactos_pizza.factory;

import com.mycompany.refactos_pizza.Enums.Size;

public class MediumDrink extends Drink {

    public MediumDrink(String name, String description) {
        super(name, description, 3.0, Size.DrinkSize.MEDIUM);
    }

    @Override
    public String toString() {
        return "MediumDrink{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
