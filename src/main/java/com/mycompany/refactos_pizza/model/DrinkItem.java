package com.mycompany.refactos_pizza.model;

public class DrinkItem extends Item {

    public DrinkItem(String name, String description, Double price) {
        super(name, description, price);
    }
    
    @Override
    public String toString(){
        return this.getName() + " " + this.getDescription();
    }
}
