package com.mycompany.refactos_pizza.factory;

public class GiantComboFactory extends AbstractFactory{
    @Override
    public Pizza getPizza(String name, String description){
        return new GiantPizza(name, description);
    }

    @Override
    public Drink getDrink(String name, String description) {
        return new GiantDrink(name, description);
    }
}
