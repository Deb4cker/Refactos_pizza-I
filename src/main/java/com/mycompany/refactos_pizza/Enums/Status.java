package com.mycompany.refactos_pizza.Enums;

public enum Status {
    
    PROCESSING("Your order is processing"),
    PENDING("Your order is on queue"),
    PREPARING("We are preparing your order!"),
    READY_TO_DELIVER("The waiter will soon deliver your order"),
    DELIVERED("Your order is already delivered "),
    CANCELLED("Your order has been cancelled");
    
    public final String value;
    
    Status (String value){
        this.value = value;
    }   
}