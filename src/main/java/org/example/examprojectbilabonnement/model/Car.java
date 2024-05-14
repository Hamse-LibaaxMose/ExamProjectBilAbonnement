package org.example.examprojectbilabonnement.model;

public class Car {
    private int carNumberID;
    private String model;
    private String type;
    private int frameNumber;

    public Car(int carNumberID, String model, String type, int frameNumber) {
        this.carNumberID = carNumberID;
        this.model = model;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(int frameNumber) {
        this.frameNumber = frameNumber;
    }

}
