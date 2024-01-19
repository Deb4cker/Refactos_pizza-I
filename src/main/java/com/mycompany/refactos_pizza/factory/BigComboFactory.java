package com.mycompany.refactos_pizza.factory;

public class BigComboFactory extends AbstractFactory{

    @Override
    public Pizza getPizza(String name, String description){
        return new BigPizza(name, description);
    }

    @Override
    public Drink getDrink(String name, String description) {
        return new BigDrink(name, description);
    }
}
