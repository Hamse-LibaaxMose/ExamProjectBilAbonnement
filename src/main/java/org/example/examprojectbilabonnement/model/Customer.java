package org.example.examprojectbilabonnement.model;

public class Customer {
    private int customerID;
    private String name;
    private String adress;
    private String mail;
    private String phoneNumber;

    public Customer(int customerID, String name, String adress, String mail, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.adress = adress;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public Customer(){

    }

    public Customer(String name, String adress, String mail, String phoneNumber) {
        this.name = name;
        this.adress = adress;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String adress, String mail) {
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
