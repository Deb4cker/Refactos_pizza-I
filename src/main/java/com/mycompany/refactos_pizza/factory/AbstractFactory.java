package com.mycompany.refactos_pizza.factory;

public abstract class AbstractFactory {
    public abstract Pizza getPizza(String name, String description);
    public abstract Drink getDrink(String name, String description);
}
