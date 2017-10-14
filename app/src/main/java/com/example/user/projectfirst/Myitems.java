package com.example.user.projectfirst;

public class Myitems {
    private String cont;
    private String name;
    private String cost;

    public Myitems(String cont, String name, String cost) {
        this.cont = cont;
        this.name = name;
        this.cost = cost;
    }

    public String getCont() {
        return cont;
    }
    public String getName() {
        return name;
    }
    public String getCost() {
        return cost;
    }
}
