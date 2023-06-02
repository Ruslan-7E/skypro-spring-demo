package pro.sky.skyprospringdemo.domain;

public class Person {
    private String name;
    private String surName;
    private String passport;
    private int professionNumber;

    public Person(String name, String surName, String passport, int professionNumber) {
        this.name = name;
        this.surName = surName;
        this.passport = passport;
        this.professionNumber = professionNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassport() {
        return passport;
    }

    public int getProfessionNumber() {
        return professionNumber;
    }

    public void changePassportNumber(String passport) {
        if (passport != null && !passport.isBlank()) {
            this.passport = passport;
        }
    }
}
