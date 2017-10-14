package com.example.user.projectfirst;

public class Myitems {
    private int img;
    private String name;
    private String cost;

    public Myitems(int img, String name, String cost) {
        this.img = img;
        this.name = name;
        this.cost = cost;
    }

    public int getImg() {
        return img;
    }
    public String getName() {
        return name;
    }
    public String getCost() {
        return cost;
    }
}
