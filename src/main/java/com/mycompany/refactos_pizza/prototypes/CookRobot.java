package com.mycompany.refactos_pizza.prototypes;

import com.mycompany.refactos_pizza.Enums.Status;
import com.mycompany.refactos_pizza.model.Kitchen;
import com.mycompany.refactos_pizza.singleton.KitchenService;

public class CookRobot extends Thread implements RobotPrototype{

    private Kitchen kitchen;

    public CookRobot() {
        this.kitchen = KitchenService.getKitchen();
    }

    private boolean running = false;

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(10000);
                if (!KitchenService.getPreparingOrders().isEmpty()) {
                    var order = KitchenService.getPreparingOrders().get(0);
                    order.setStatus(Status.READY_TO_DELIVER);
                    KitchenService.getReadyOrders().add(order);
                    KitchenService.getPreparingOrders().remove(0);
                    kitchen.notifyObservers(order);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
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
            start();
        }

        running = true;
    }
    
    public void start() {
        running = true;
        super.start();
    }

    @Override
    public RobotPrototype clone() {
        return new CookRobot();
    }

}
