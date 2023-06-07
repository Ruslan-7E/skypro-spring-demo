package pro.sky.skyprospringdemo.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private String passport;
    private List<Integer> professionNumbers;

    public Person(String name, String surname, String passport, int professionNumber) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
        this.professionNumbers = new ArrayList<>(List.of(professionNumber));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassport() {
        return passport;
    }

    public List<Integer> getProfessionNumbers() {
        return professionNumbers;
    }

    public void changePassportNumber(String passport) {
        if (passport != null && !passport.isBlank()) {
            this.passport = passport;
        }
    }
}
