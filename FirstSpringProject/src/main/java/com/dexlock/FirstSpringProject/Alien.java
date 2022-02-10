package com.dexlock.FirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    private int aid;
    private String aname;
    private String planetality;
    @Autowired
    @Qualifier("Lap1")
    private Laptop laptop;

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPlanetality() {
        return planetality;
    }

    public void setPlanetality(String planetality) {
        this.planetality = planetality;
    }

    public void show(){
        System.out.println("in the alien show");
        laptop.compile();
    }
}
