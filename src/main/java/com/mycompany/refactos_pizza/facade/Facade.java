package com.mycompany.refactos_pizza.facade;

import java.util.HashMap;
import java.util.Map;

import com.mycompany.refactos_pizza.singleton.KitchenService;
import com.mycompany.refactos_pizza.view.MenuView;

public class Facade {

    Map<String, MenuView> menuViews = new HashMap<>();

    public void openView(String name) {
        var view = new MenuView(name);
        view.setVisible(true);
        menuViews.put(name, view);
    }

    public void closeViewWithId(String key) {
      var view = menuViews.get(key);
        view.dispose();
        menuViews.remove(key);
    }

    public void closeAllViews() {
        menuViews.forEach((key, view) -> view.dispose());
        menuViews.clear();
    }

    public void startKitchen() {
        KitchenService.start();
    }

    public void stopKitchen() {
        KitchenService.stop();
    }

    public void createAssistantRobot() {
        KitchenService.getKitchen().creatAssistantRobot();
    }

    public void createCookRobot() {
        KitchenService.getKitchen().creatCookRobot();
    }

    public void createWaiterRobot() {
        KitchenService.getKitchen().creatWaiterRobot();
    }

    public void createAllRobots(int quantity) {
        for (int i = 0; i < quantity; i++) {
            createAssistantRobot();
            createCookRobot();
            createWaiterRobot();
        }
    }

}
