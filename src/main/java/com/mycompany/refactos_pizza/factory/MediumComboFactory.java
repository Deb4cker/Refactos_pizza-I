package com.mycompany.refactos_pizza.factory;

public class MediumComboFactory extends AbstractFactory{

    @Override
    public Pizza getPizza(String name, String description) {
        return new MediumPizza(name, description);
    }

    @Override
    public Drink getDrink(String name, String description) {
        return new MediumDrink(name, description);
    }

}
