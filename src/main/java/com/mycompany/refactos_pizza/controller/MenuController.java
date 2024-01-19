package com.mycompany.refactos_pizza.controller;

import com.mycompany.refactos_pizza.model.DrinkItem;
import com.mycompany.refactos_pizza.model.Order;
import com.mycompany.refactos_pizza.model.PizzaItem;
import com.mycompany.refactos_pizza.singleton.KitchenService;

import java.util.List;

import com.mycompany.refactos_pizza.commands.CreateOrderCommand;
import com.mycompany.refactos_pizza.commands.Invoker;
import com.mycompany.refactos_pizza.dao.DrinkDao;
import com.mycompany.refactos_pizza.dao.PizzaDao;
import com.mycompany.refactos_pizza.factory.AbstractFactory;
import com.mycompany.refactos_pizza.model.Observer;

public class MenuController {

    private PizzaDao pizzaDao = new PizzaDao();
    private DrinkDao drinkDao = new DrinkDao();

    private Invoker<CreateOrderCommand> createOrderCommand = new Invoker<>();

    public void doOrder(Order order){
        createOrderCommand.setCommand(new CreateOrderCommand(order));
        createOrderCommand.executeCommand();
    }

    public List<PizzaItem> getPizzaItems(){
        return pizzaDao.getAll();
    }

    public List<DrinkItem> getDrinkItems(){
        return drinkDao.getAll();
    }
    
    public void addObserver(Observer o){
        KitchenService.getKitchen().addObserver(o);
    }
    
    public String[] createOrder(AbstractFactory comboFactory, PizzaItem pizza, DrinkItem drink, String clientId){
        var pizzaOrder = comboFactory.getPizza(pizza.getName(), pizza.getDescription());
        var drinkOrder = comboFactory.getDrink(drink.getName(), drink.getDescription());
        Order order = new Order(pizzaOrder, drinkOrder, clientId);
        doOrder(order);

        var id = String.valueOf(order.getId());
        var status = order.getStatus();
        var size = pizzaOrder.getSizeString();
        
        return new String[]{id, size, status};
    }
}
