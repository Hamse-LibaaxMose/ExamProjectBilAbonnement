package org.example.examprojectbilabonnement.model;

import java.util.Date;

public class RentalContract {
    private int rentalContractID;
    private String startDate;
    private String endDate;
    private int price;
    private int customerID;
    private int subscriptionID;
    private int carNumberID;
    private int pickupLocationID;
    private int deliveryLocationID;
    public RentalContract() {
    }

    public RentalContract(String startDate, String endDate, int price, int customerID, int subscriptionID, int carNumberID, int pickupLocationID, int deliveryLocationID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.customerID = customerID;
        this.subscriptionID = subscriptionID;
        this.carNumberID = carNumberID;
        this.pickupLocationID = pickupLocationID;
        this.deliveryLocationID = deliveryLocationID;
    }

    public RentalContract(int rentalContractID, String startDate, String endDate, int price, int customerID, int subscriptionID, int carNumberID, int pickupLocationID, int deliveryLocationID) {
        this.rentalContractID = rentalContractID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.customerID = customerID;
        this.subscriptionID = subscriptionID;
        this.carNumberID = carNumberID;
        this.pickupLocationID = pickupLocationID;
        this.deliveryLocationID = deliveryLocationID;
    }

    public int getRentalContractID() {
        return rentalContractID;
    }

    public void setRentalContractID(int rentalContractID) {
        this.rentalContractID = rentalContractID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public int getCarNumberID() {
        return carNumberID;
    }

    public void setCarNumberID(int carNumberID) {
        this.carNumberID = carNumberID;
    }

    public int getPickupLocationID() {
        return pickupLocationID;
    }

    public void setPickupLocationID(int pickupLocationID) {
        this.pickupLocationID = pickupLocationID;
    }

    public int getDeliveryLocationID() {
        return deliveryLocationID;
    }

    public void setDeliveryLocationID(int deliveryLocationID) {
        this.deliveryLocationID = deliveryLocationID;
    }
}
