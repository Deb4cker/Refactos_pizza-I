package com.mycompany.refactos_pizza.factory;

import com.mycompany.refactos_pizza.Enums.Size;

public class BigDrink extends Drink{

    public BigDrink(String name, String description) {
        super(name, description, 4.0, Size.DrinkSize.BIG);
    }

    @Override
    public String toString() {
        return "BigDrink{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
