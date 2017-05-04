package com.bodyash.pizzaria.bean;

public enum State {

    ORDERED("Ordered"),
    REJECTED("Rejected"),
    DELIVERY("Deliery"),
    DELIVERED("Delivered");

    private String state;

    private State(final String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return this.state;
    }

    public String getName() {
        return this.name();
    }


}