package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.exceptions.BadPersonNumberException;
import pro.sky.skyprospringdemo.service.PersonService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping(path = "/person/by-passport")
    public String getPersonInfo(@RequestParam("passport") String passport) {
        return personService.getPersonByPassport(passport);
    }

    @GetMapping(path = "/person/profession/add")
    public String addProfession(@RequestParam("passport") String passport,
                                @RequestParam("profession") Integer profession) {
        personService.addProfession(passport, profession);
        return "Profession has been added successfully!";
    }

    @GetMapping(path = "/person/add")
    public String addPerson(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("passport") String passport,
                            @RequestParam("profession") Integer professionNumber) {
        Person person = new Person(
                name,
                surname,
                passport,
                professionNumber
        );
        personService.addPerson(person);
        return "Person added successfully!";
    }

    @GetMapping(path = "/persons/by-profession")
    public String getByProfession(@RequestParam("profession") int profession) {
        final List<Person> personsByProfession = personService.getPersonsByProfession(profession);
        final List<String> passports = new ArrayList<>();
        for (final Person person : personsByProfession) {
            passports.add(person.getPassport());
        }
        return passports.toString();
    }
}
