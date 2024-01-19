package com.mycompany.refactos_pizza.singleton;

import java.util.List;

import com.mycompany.refactos_pizza.model.Kitchen;
import com.mycompany.refactos_pizza.model.Order;

//Singleton: Um serviço que da acesso à unica instância da cozinha para todo o sistema

public class KitchenService {

    private static Kitchen systemKitchen = new Kitchen();
    
    public KitchenService() {
        if(systemKitchen == null){
            systemKitchen = new Kitchen();
        }
    }

    public static Kitchen getKitchen(){
        return systemKitchen;
    }

    public List<Order> getPendingOrders(){
        return systemKitchen.getPendingOrders();
    }

    public List<Order> getPreparingOrders(){
        return systemKitchen.getPreparingOrders();
    }

    public List<Order> getReadyOrders(){
        return systemKitchen.getReadyOrders();
    }

    public void start(){
        systemKitchen.start();
    }

    public void stop(){
        systemKitchen.stop();
    }
}
