package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Driver;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.domain.TruckDriver;
import pro.sky.skyprospringdemo.exceptions.BadPersonNumberException;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    List<Person> persons = List.of(
            new Person(
                    "Jean",
                    "Renault",
                    "12345",
                    2),
            new Person(
                    "Luke",
                    "Besson",
                    "54321",
                    3),
            new Person(
                    "Gerard",
                    "Depardier",
                    "41232",
                    0),
            new Driver(
                    "Jason",
                    "Statham",
                    "928374",
                    "3491",
                    1),
            new TruckDriver(
                    "Robert",
                    "Patrick",
                    "1000",
                    "2345",
                    1)
    );
    String[] professions = {
            "unemployed",
            "driver",
            "woodworker",
            "carpenter"
    };


    @Override
    public String getPerson(Integer number) throws BadPersonNumberException {
        final Person person;
        if (number >= persons.size()) {
            throw new BadPersonNumberException("Person number is greater than array size");
        }
        person = persons.get(number);
        final String personDescription = ""
                + person.getName() + " "
                + person.getSurName() + " "
                + person.getPassport() + " "
                + professions[person.getProfessionNumber()];
        return personDescription;
    }
}
