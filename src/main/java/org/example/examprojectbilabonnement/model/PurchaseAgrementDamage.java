package org.example.examprojectbilabonnement.model;

public class PurchaseAgrementDamage {
    private int purchaseAgreement_damageTypeID;
    private int purchaseAgreementID;
    private String name;
    private int price;

    public PurchaseAgrementDamage() {
    }

    public PurchaseAgrementDamage(int purchaseAgreement_damageTypeID, int purchaseAgreementID, String name, int price) {
        this.purchaseAgreement_damageTypeID = purchaseAgreement_damageTypeID;
        this.purchaseAgreementID = purchaseAgreementID;
        this.name = name;
        this.price = price;
    }

    public int getPurchaseAgreementID() {
        return purchaseAgreementID;
    }

    public void setPurchaseAgreementID(int purchaseAgreementID) {
        this.purchaseAgreementID = purchaseAgreementID;
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

    public int getPurchaseAgreement_damageTypeID() {
        return purchaseAgreement_damageTypeID;
    }

    public void setPurchaseAgreement_damageTypeID(int purchaseAgreement_damageTypeID) {
        this.purchaseAgreement_damageTypeID = purchaseAgreement_damageTypeID;
    }
}
