package com.dexlock.FirstSpringProject;

import org.springframework.stereotype.Component;

@Component("Lap1")
public class Laptop {
    private int lid;
    private String brand;
    private int price;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void compile(){
        System.out.println("compiling the laptop........");
    }
}
