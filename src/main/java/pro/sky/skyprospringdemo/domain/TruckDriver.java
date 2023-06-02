package pro.sky.skyprospringdemo.domain;

public class TruckDriver extends Driver {

    public TruckDriver(String name, String surName, String passport, String driverLicenseNumber, int professionNumber) {
        super(name, surName, passport, driverLicenseNumber, professionNumber);
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        if (driverLicenseNumber != null && driverLicenseNumber.startsWith("2")) {
            super.setDriverLicenseNumber(driverLicenseNumber);
        }
    }
}
