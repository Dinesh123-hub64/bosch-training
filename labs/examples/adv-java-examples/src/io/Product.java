package io;

import java.io.Serializable;

public class Product implements Serializable
{
    private  int id;
    private ProductCategory category;
    private String description;
    private double price;
    private boolean active;

    private static final long serialVersionUID = 1L;

    public Product(int id, ProductCategory category,String description, double price, boolean active) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.price = price;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}

enum ProductCategory {
    MOBILES,LAPTOPS,FURNITURE,STATIONARY
}
