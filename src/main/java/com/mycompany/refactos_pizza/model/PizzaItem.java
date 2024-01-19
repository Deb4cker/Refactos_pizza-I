package com.mycompany.refactos_pizza.model;

public class PizzaItem extends Item{
        public PizzaItem(String name, String description, Double price) {
            super(name, description, price);
        }

        @Override
        public String toString() {
            return getName();
        }
}
