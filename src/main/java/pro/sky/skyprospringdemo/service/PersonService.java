package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.exceptions.BadPersonNumberException;

import java.util.List;

public interface PersonService {

    // метод ниже возвращает все допустимые профессии у экземпляра класса из списка профессий
    List<Person> getPersonsByProfessions(List<Integer> professionNumbers);

    void addPerson(Person person);

    void addProfession(String passport, Integer profession);

    String getPersonByPassport(String passport);
}
