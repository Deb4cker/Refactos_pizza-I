package com.mycompany.refactos_pizza.factory;

public class ShortComboFactory extends AbstractFactory{

    @Override
    public Pizza getPizza(String name, String description){
        return new ShortPizza(name, description);
    }

    @Override
    public Drink getDrink(String name, String description) {
        return new ShortDrink(name, description);
    }

}
