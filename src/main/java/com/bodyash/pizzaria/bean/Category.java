package com.bodyash.pizzaria.bean;

public enum Category {

    PIZZA("Pizza"),
    DRINK("Drink"),
    DESSERT("Dessert"),
    OTHER("Other");

    private String category;

    private Category(final String category) {
        this.category = category;
    }

    public String getState() {
        return this.category;
    }

    @Override
    public String toString() {
        return this.category;
    }

    public String getName() {
        return this.name();
    }
	
}
