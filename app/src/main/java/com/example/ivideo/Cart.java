package com.example.ivideo;

public class Cart {
    private  String name;
    private  String quality;
    private  String price;


    public Cart(String name, String quality, String price) {
        this.name = name;
        this.quality = quality;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
