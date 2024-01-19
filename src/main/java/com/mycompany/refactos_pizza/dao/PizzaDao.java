package com.mycompany.refactos_pizza.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mycompany.refactos_pizza.model.PizzaItem;

public class PizzaDao implements IRepository<PizzaItem>{

    private static boolean isPopulated = false;
    private static List<PizzaItem> list = new ArrayList<>();
    
    public PizzaDao(){
        populatePizzas();
    }

    public List<PizzaItem> getAll() {
        return list;
    }

    @Override
    public PizzaItem getById(long id) {
        return list.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }

    public PizzaItem getByName(String name) {
        return list.stream().filter(o -> o.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void add(PizzaItem obj) {
        if (obj != null) {
            list.add(obj);
        }
    }

    @Override
    public void remove(PizzaItem obj) {
        if (obj != null) {
            list.remove(obj);
        }
    }

    private void populatePizzas(){

        if (!isPopulated) {
            
            var pizzas = new PizzaItem[]{
                new PizzaItem("Calabresa", "calabresa, cebola, azeitona, mussarela", 30.0),
                new PizzaItem("Frango", "frango, milho, mussarela", 30.0),
                new PizzaItem("Marguerita", "tomate, mussarela, manjericão", 30.0),
                new PizzaItem("Portuguesa", "presunto, ovo, cebola, azeitona, mussarela", 30.0),
                new PizzaItem("Quatro Queijos", "mussarela, provolone, parmesão, catupiry", 30.0),
                new PizzaItem("Vegetariana", "milho, ervilha, palmito, cebola, azeitona, mussarela", 30.0),
                new PizzaItem("Brigadeiro", "brigadeiro, granulado", 30.0),
                new PizzaItem("Chocolate", "chocolate, morango, granulado", 30.0),
                new PizzaItem("Romeu e Julieta", "goiabada, mussarela", 30.0),
                new PizzaItem("Banana", "banana, canela, açúcar", 30.0),
                new PizzaItem("Banana com Chocolate", "banana, chocolate, canela, açúcar", 30.0),
                new PizzaItem("Banana com Canela", "banana, canela, açúcar", 30.0),
                new PizzaItem("Banana com Chocolate e Canela", "banana, chocolate, canela, açúcar", 30.0),
                new PizzaItem("Banana com Chocolate e Leite Condensado", "banana, chocolate, leite condensado", 30.0),
                new PizzaItem("Banana com Leite Condensado", "banana, leite condensado", 30.0),
                new PizzaItem("Banana com Leite Condensado e Canela", "banana, leite condensado, canela", 30.0),
                new PizzaItem("Banana com Leite Condensado e Chocolate", "banana, leite condensado, chocolate", 30.0)
        };

        list.addAll(Arrays.asList(pizzas));
        isPopulated = true;
        }
    }

}
