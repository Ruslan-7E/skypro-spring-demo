package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Driver;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.domain.TruckDriver;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {
    Map<String, Person> persons = new HashMap<>(Map.of(
            "12345",
            new Person(
                    "Jean",
                    "Renault",
                    "12345",
                    2),
            "54321",
            new Person(
                    "Luke",
                    "Besson",
                    "54321",
                    3),
            "41232",
            new Person(
                    "Gerard",
                    "Depardier",
                    "41232",
                    0),
            "928374",
            new Driver(
                    "Jason",
                    "Statham",
                    "928374",
                    "3491",
                    1),
            "1000",
            new TruckDriver(
                    "Robert",
                    "Patrick",
                    "1000",
                    "2345",
                    1)
    ));
    String[] professions =
            {
                    "unemployed",
                    "driver",
                    "woodworker",
                    "carpenter",
                    "actor"
            };

    Map<String, Integer> professionsCodes = Map.of(
            "unemployed", 0,
            "driver", 1,
            "woodworker", 2,
            "carpenter", 3,
            "actor", 4
    );

    public List<Person> getPersonsByProfession(Integer professionNumber) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getProfessionNumbers().contains(professionNumber)) {
                result.add(person);
            }
        }
        return result;
    }

    // метод ниже возвращает все допустимые профессии у экземпляра класса из списка профессий
    @Override
    public List<Person> getPersonsByProfessions(List<Integer> professionNumbers) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getProfessionNumbers().containsAll(professionNumbers)) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public void addPerson(Person person) {
        persons.put(person.getPassport(), person);
    }

    @Override
    public void addProfession(String passport, Integer profession) {
        final Person person = persons.get(passport);
        if (person == null) {
            throw new RuntimeException("Person with that number isn't found!");
        }
        person.getProfessionNumbers().add(profession);

    }

    @Override
    public String getPersonByPassport(String passport) {
        final Person person = persons.get(passport);
        if (person == null) {
            throw new RuntimeException("Person with that number isn't found!");
        }
        final String personDescription = ""
                + person.getName() + " "
                + person.getSurname() + " "
                + person.getPassport() + " "
                + getProfessionNames(person.getProfessionNumbers());
        return personDescription;
    }

    private String getProfessionNames(Set<Integer> professionNumbers) {
        String result = "";
        for (Integer professionNumber : professionNumbers) {
            result = result + " " + professions[professionNumber];
        }
        return result;
    }
}

