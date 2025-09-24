package com.payoyo.inyeccion_dependencias.models;

public class Producto {

    private Long id;
    private String name;
    private double price;

    public Producto(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Producto() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    

    
    
}
