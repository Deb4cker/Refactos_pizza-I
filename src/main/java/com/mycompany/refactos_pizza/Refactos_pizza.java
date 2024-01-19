package com.mycompany.refactos_pizza;

import com.mycompany.refactos_pizza.facade.Facade;

public class Refactos_pizza {

    public static void main(String[] args) {
        var facade = new Facade();
        facade.openView("Carlin Bananal");
        facade.startKitchen();
    }
}
