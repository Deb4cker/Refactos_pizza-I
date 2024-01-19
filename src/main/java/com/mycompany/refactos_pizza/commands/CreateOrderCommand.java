package com.mycompany.refactos_pizza.commands;

import com.mycompany.refactos_pizza.model.Kitchen;
import com.mycompany.refactos_pizza.model.Order;
import com.mycompany.refactos_pizza.singleton.KitchenService;

public class CreateOrderCommand implements Command{

    private Order order;
    private Kitchen kitchen = KitchenService.getKitchen();

    public CreateOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        kitchen.addOrder(order);
    }
}
