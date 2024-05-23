package org.example.examprojectbilabonnement.model;

public class DamageType {
    private int damageTypeID;
    private String name;
    private int price;

    public DamageType() {
    }

    public DamageType(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public DamageType(int damageTypeID, String name, int price) {
        this.damageTypeID = damageTypeID;
        this.name = name;
        this.price = price;
    }




    public int getDamageTypeID() {
        return damageTypeID;
    }

    public void setDamageTypeID(int damageTypeID) {
        this.damageTypeID = damageTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
