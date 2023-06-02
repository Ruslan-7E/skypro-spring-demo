package pro.sky.skyprospringdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
        try {
            return personService.getPerson(number);
        } catch (BadPersonNumberException e) {
            return "Please, try another number";
        } catch (Exception e) {
            e.printStackTrace();
            return "Please, try later";
        }
    }
}
