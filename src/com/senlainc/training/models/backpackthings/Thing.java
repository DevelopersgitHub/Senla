package com.senlainc.training.models.backpackthings;

public class Thing {
    private long id;
    private String name;
    private double weight;
    private double cost;

    public Thing(long id, String name, double weight, double cost) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Thing: " +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
