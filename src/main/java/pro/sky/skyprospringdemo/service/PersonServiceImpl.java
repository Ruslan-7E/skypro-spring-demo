package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Driver;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.domain.TruckDriver;
import pro.sky.skyprospringdemo.exceptions.BadPersonNumberException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    List<String> professions = List.of
            (
                    "unemployed",
                    "driver",
                    "woodworker",
                    "carpenter"
            );


    @Override
    public void addPerson(Person person) {
        persons.put(person.getPassport(), person);
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
                + professions.get(person.getProfessionNumber());
        return personDescription;
    }
}

