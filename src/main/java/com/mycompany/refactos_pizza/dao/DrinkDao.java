package com.mycompany.refactos_pizza.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mycompany.refactos_pizza.model.DrinkItem;

public class DrinkDao implements IRepository<DrinkItem> {
    
    private static boolean isPopulated = false;
    private static List<DrinkItem> list = new ArrayList<>();

    public DrinkDao(){
        populateDrinks();
    }

    public List<DrinkItem> getAll() {
        return list;
    }

    @Override
    public DrinkItem getById(long id) {
        return list.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }

    public DrinkItem getByName(String name) {
        return list.stream().filter(o -> o.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void add(DrinkItem obj) {
        if (obj != null) {
            list.add(obj);
        }
    }

    @Override
    public void remove(DrinkItem obj) {
        if (obj != null) {
            list.remove(obj);
        }
    }

    private void populateDrinks(){
        if (!isPopulated){

            var drinks = new DrinkItem[]{
                new DrinkItem("Coca-Cola", "Copo", 2.5),
                new DrinkItem("Fanta", "Copo", 2.5),
                new DrinkItem("Sprite", "Copo", 2.5),
                new DrinkItem("Guaraná", "Copo", 2.5),
                new DrinkItem("Agua", "Copo", 2.5)
            };

            list.addAll(Arrays.asList(drinks));
            isPopulated = true;
       }
    }
}
