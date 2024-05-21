package org.example.examprojectbilabonnement.model;

import java.util.Date;

public class RentalContractView extends RentalContract{
    private String customerName;
    private String subscriptionName;
    private String carModelName;
    private String carFrameNumber;
    private String pickupLocationName;
    private String deliveryLocationName;

    public RentalContractView() {
    }

    public RentalContractView(String customerName, String subscriptionName, String carModelName, String carFrameNumber, String pickupLocationName, String deliveryLocationName) {
        this.customerName = customerName;
        this.subscriptionName = subscriptionName;
        this.carModelName = carModelName;
        this.carFrameNumber = carFrameNumber;
        this.pickupLocationName = pickupLocationName;
        this.deliveryLocationName = deliveryLocationName;
    }

    public RentalContractView(int rentalContractID, String startDate, String endDate, int price, int customerID, int subscriptionID, int carNumberID, int pickupLocationID, int deliveryLocationID, String customerName, String subscriptionName, String carModelName, String carFrameNumber, String pickupLocationName, String deliveryLocationName) {
        super(rentalContractID, startDate, endDate, price, customerID, subscriptionID, carNumberID, pickupLocationID, deliveryLocationID);
        this.customerName = customerName;
        this.subscriptionName = subscriptionName;
        this.carModelName = carModelName;
        this.carFrameNumber = carFrameNumber;
        this.pickupLocationName = pickupLocationName;
        this.deliveryLocationName = deliveryLocationName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarFrameNumber() {
        return carFrameNumber;
    }

    public void setCarFrameNumber(String carFrameNumber) {
        this.carFrameNumber = carFrameNumber;
    }

    public String getPickupLocationName() {
        return pickupLocationName;
    }

    public void setPickupLocationName(String pickupLocationName) {
        this.pickupLocationName = pickupLocationName;
    }

    public String getDeliveryLocationName() {
        return deliveryLocationName;
    }

    public void setDeliveryLocationName(String deliveryLocationName) {
        this.deliveryLocationName = deliveryLocationName;
    }
}
