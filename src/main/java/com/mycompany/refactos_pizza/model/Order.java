package com.mycompany.refactos_pizza.model;

import com.mycompany.refactos_pizza.Enums.Size;
import com.mycompany.refactos_pizza.Enums.Status;
import com.mycompany.refactos_pizza.factory.Drink;
import com.mycompany.refactos_pizza.factory.Pizza;

public class Order extends AbstractModel<Order> {
    
    private double totalPrice;
    private String clientId;
    private Status status;
    private Pizza pizza;
    private Drink drink;
    private Size.PizzaSize pizzaSize;

    public Order(Pizza pizza, Drink drink, String clientId){
        this.status = Status.PENDING;
        this.clientId = clientId;
        this.pizza = pizza;
        this.drink = drink;
        this.pizzaSize = pizza.getSize();
        setTotalPrice();
    }

    public boolean isPending(){
        return status == Status.PENDING;
    }

    public String getClientId() {
        return clientId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice() {
        totalPrice = pizza.getPrice() + drink.getPrice();
    }
    
    public void updateTotal(){
        setTotalPrice();
    }
    
    public String getStatus(){
        return status.value;
    }
    
    public void setStatus(Status status){
        this.status = status;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Size.PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public String getSizeString(){
        return  pizzaSize.name();
    }

    public void setPizzaSize(Size.PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    
}
