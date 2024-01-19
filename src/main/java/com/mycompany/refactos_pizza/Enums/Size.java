package com.mycompany.refactos_pizza.Enums;

public class Size{

    public enum PizzaSize {
        SMALL (1.0f, "Short", 4),
        MEDIUM(1.2f, "Medium", 8),
        BIG   (1.5f, "Big", 12),
        GIANT (2.0f, "Giant", 20);
        
        public float priceFactor;
        final String name;
        int slicesNumber;
        
        PizzaSize(float price_factor, String name, int slicesNumber){
            this.priceFactor = price_factor;
            this.name = name;
            this.slicesNumber = slicesNumber;
        }
    }
    
    public enum DrinkSize {
        
        SMALL (1.0f, "Small", 0.25f),
        MEDIUM(1.2f, "Medium", 0.5f),
        BIG   (1.5f, "Big", 1.0f),
        GIANT (2.0f, "Giant", 2.0f);
    
        public float priceFactor;
        final String name;
        float volume;
        
        DrinkSize(float price_factor, String name, float volume){
            this.priceFactor = price_factor;
            this.name = name;
            this.volume = volume;
        }
    }
}
