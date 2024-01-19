package com.mycompany.refactos_pizza.prototypes;

import com.mycompany.refactos_pizza.Enums.Status;
import com.mycompany.refactos_pizza.model.Kitchen;
import com.mycompany.refactos_pizza.singleton.KitchenService;

public class WaiterRobot extends Thread implements RobotPrototype{

    private KitchenService kitchenService;
    private Kitchen kitchen;

    public WaiterRobot() {
        this.kitchenService = new KitchenService();
        this.kitchen = KitchenService.getKitchen();
    }

    private boolean running = false;

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(10000);
                if (!kitchenService.getReadyOrders().isEmpty()) {
                    var order = kitchenService.getReadyOrders().get(0);
                    order.setStatus(Status.DELIVERED);
                    kitchenService.getReadyOrders().remove(0);
                    kitchen.notifyObservers(order);
                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void start() {
        running = true;
        super.start();
    }

    @Override
    public void shutdown() {
        running = false;
    }

    @Override
    public void restart() {
        running = false;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        running = true;
        super.start();
    }

    @Override
    public RobotPrototype clone() {
        return new WaiterRobot();
    }
    
}
