package org.example.examprojectbilabonnement.model;

public class Car {
    private int carNumberID;
    private String model;
    private String brand;
    private int frameNumber;

    public Car(){

    }
    public Car(int carNumberID, String model, String brand, int frameNumber) {
        this.carNumberID = carNumberID;
        this.model = model;
        this.brand = brand;
        this.frameNumber = frameNumber;
    }

    public Car(String model, String brand, int frameNumber) {
        this.model = model;
        this.brand = brand;
        this.frameNumber = frameNumber;
    }

    public int getCarNumberID() {
        return carNumberID;
    }

    public void setCarNumberID(int carNumberID) {
        this.carNumberID = carNumberID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(int frameNumber) {
        this.frameNumber = frameNumber;
    }

}
