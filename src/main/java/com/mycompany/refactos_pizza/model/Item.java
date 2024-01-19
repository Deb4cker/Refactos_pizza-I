package com.mycompany.refactos_pizza.model;


public class Item extends AbstractModel<Item>{
    private String name;
    private String description;
    private Double basePrice;

    public Item(String name, String description, Double price) {
        super();
        this.name = name;
        this.description = description;
        this.basePrice = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return basePrice;
    }

    public void setPrice(Double price) {
        this.basePrice = price;
    }
}
