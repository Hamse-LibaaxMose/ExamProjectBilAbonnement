package org.example.examprojectbilabonnement.model;

public class Location {
    private int locationID;
    private String name;
    private String city;
    private int zipCode;
    private String adress;

    public Location() {
    }

    public Location(String name, String city, int zipCode, String adress) {
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
        this.adress = adress;
    }

    public Location(int locationID, String name, String city, int zipCode, String adress) {
        this.locationID = locationID;
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
        this.adress = adress;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }


}
