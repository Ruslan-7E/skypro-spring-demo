package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.exceptions.BadPersonNumberException;
import pro.sky.skyprospringdemo.service.PersonService;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/person")
    public String getPersonInfo(@RequestParam("number") Integer number) {
        final String person;
        person = personService.getPerson(number);
        return person;
    }

    @GetMapping(path = "/person/by-passport")
    public String getPersonInfo(@RequestParam("passport") String passport) {
        return personService.getPersonByPassport(passport);
    }

    @GetMapping(path = "/person/add")
    public String addPerson(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("passport") String passport,
                            @RequestParam("profession") Integer professionNumber)
    {
        Person person = new Person(
                name,
                surname,
                passport,
                professionNumber
        );
        personService.addPerson(person);
        return "Person added successfully!";
    }
}
