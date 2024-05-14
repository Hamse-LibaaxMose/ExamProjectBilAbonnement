package org.example.examprojectbilabonnement.model;

public class DamageReport {
    private int damageReportID;
    private int exceedKm;

    public DamageReport(int damageReportID, int exceedKm) {
        this.damageReportID = damageReportID;
        this.exceedKm = exceedKm;
    }

    public int getDamageReportID() {
        return damageReportID;
    }

    public void setDamageReportID(int damageReportID) {
        this.damageReportID = damageReportID;
    }

    public int getExceedKm() {
        return exceedKm;
    }

    public void setExceedKm(int exceedKm) {
        this.exceedKm = exceedKm;
    }
}
