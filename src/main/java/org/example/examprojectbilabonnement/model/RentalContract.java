package org.example.examprojectbilabonnement.model;

import java.util.Date;

public class RentalContract {
    private int rentalContractID;
    private Date startDate;
    private Date endDate;
    private int price;
    private int abonnement;
    private int customerID;

    private int damageReportID;
    private int carNumberID;
    private int deliveryLocationID;
    private int pickupLocationID;

    public RentalContract(int rentalContractID, Date startDate, Date endDate, int price, int abonnement, int customerID, int damageReportID, int carNumberID, int deliveryLocationID, int pickupLocationID) {
        this.rentalContractID = rentalContractID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.abonnement = abonnement;
        this.customerID = customerID;
        this.damageReportID = damageReportID;
        this.carNumberID = carNumberID;
        this.deliveryLocationID = deliveryLocationID;
        this.pickupLocationID = pickupLocationID;
    }

    public int getRentalContractID() {
        return rentalContractID;
    }

    public void setRentalContractID(int rentalContractID) {
        this.rentalContractID = rentalContractID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(int abonnement) {
        this.abonnement = abonnement;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getDamageReportID() {
        return damageReportID;
    }

    public void setDamageReportID(int damageReportID) {
        this.damageReportID = damageReportID;
    }

    public int getCarNumberID() {
        return carNumberID;
    }

    public void setCarNumberID(int carNumberID) {
        this.carNumberID = carNumberID;
    }

    public int getDeliveryLocationID() {
        return deliveryLocationID;
    }

    public void setDeliveryLocationID(int deliveryLocationID) {
        this.deliveryLocationID = deliveryLocationID;
    }

    public int getPickupLocationID() {
        return pickupLocationID;
    }

    public void setPickupLocationID(int pickupLocationID) {
        this.pickupLocationID = pickupLocationID;
    }
}
