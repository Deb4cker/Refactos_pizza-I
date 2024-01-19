package com.mycompany.refactos_pizza.prototypes;

public interface RobotPrototype {
    RobotPrototype clone();
    void start();
    void shutdown();
    void restart();    
}
