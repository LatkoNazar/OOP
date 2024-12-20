package org.example;

public class Item {
    private final String name;
    private final double price;
    private final String currency;

    public Item(String name, double price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public void describe() {
        System.out.println("Name: " + name + ". Price: " + price + ". Currency: " + currency);
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }
}