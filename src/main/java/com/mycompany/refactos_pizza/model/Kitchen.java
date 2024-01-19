package com.mycompany.refactos_pizza.model;

import com.mycompany.refactos_pizza.prototypes.AssistantRobot;
import com.mycompany.refactos_pizza.prototypes.CookRobot;
import com.mycompany.refactos_pizza.prototypes.RobotPrototype;
import com.mycompany.refactos_pizza.prototypes.WaiterRobot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Kitchen {
    
    private List<Order> pendingOrders = Collections.synchronizedList(new ArrayList<>());
    private List<Order> preparingOrders = Collections.synchronizedList(new ArrayList<>());
    private List<Order> readyOrders = Collections.synchronizedList(new ArrayList<>());

    private static List<Observer> observers = Collections.synchronizedList(new ArrayList<>());

    private static List<RobotPrototype> robots = Collections.synchronizedList(new ArrayList<>());

    private static RobotPrototype assistantRobot = new AssistantRobot();
    private static RobotPrototype cookRobot = new CookRobot();
    private static RobotPrototype waiterRobot = new WaiterRobot();
    
    public void addOrder(Order order) {
        pendingOrders.add(order);
        notifyObservers(order);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void addRobots() {
        robots.add(assistantRobot);
        robots.add(cookRobot);
        robots.add(waiterRobot);
    }

    public List<Order> getPendingOrders() {
        return pendingOrders;
    }

    public List<Order> getPreparingOrders() {
        return preparingOrders;
    }

    public List<Order> getReadyOrders() {
        return readyOrders;
    }

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public void notifyObservers(Order order) {
        
        CompletableFuture.runAsync(() -> {
            observers.forEach(observer -> observer.update(order.getId(), order.getSizeString(), order.getStatus()));
        }, executor);
    }

    public void creatAssistantRobot() {
        robots.add(assistantRobot.clone());
    }

    public void creatCookRobot() {
        robots.add(cookRobot.clone());
    }

    public void creatWaiterRobot() {
        robots.add(waiterRobot.clone());
    }

    public void startRobots() {

        robots.forEach(RobotPrototype::start);
    }

    public void stopRobots() {
        robots.forEach(RobotPrototype::shutdown);
    }

    public void restartRobots() {
        robots.forEach(RobotPrototype::restart);
    }

    public void start(){
        if (robots.isEmpty()) {
            addRobots();
        }
        startRobots();
    }

    public void stop(){
        stopRobots();
    }

    public void restart(){
        restartRobots();
    }
}
