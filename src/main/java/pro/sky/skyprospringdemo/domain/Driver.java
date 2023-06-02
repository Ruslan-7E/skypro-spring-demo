package pro.sky.skyprospringdemo.domain;

public class Driver extends Person {
    private String driverLicenseNumber;

    public Driver(String name, String surName, String passport, String driverLicenseNumber, int professionNumber) {
        super(name, surName, passport, professionNumber);
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }
}
