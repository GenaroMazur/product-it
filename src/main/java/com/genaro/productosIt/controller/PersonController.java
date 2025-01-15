package com.genaro.productosIt.controller;

import com.genaro.productosIt.entity.Person;
import com.genaro.productosIt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public ArrayList<Person> getPersons(@RequestParam Map<String, String> params) {
        Person query = new Person();

        params.forEach((key, value) -> {
            switch (key) {
                case "id":
                    query.setId(Long.parseLong(value));
                    break;
                case "name":
                    query.setName(value);
                    break;
                case "email":
                    query.setEmail(value);
                    break;
                case "phone":
                    query.setPhone(value);
                    break;
                case "cell":
                    query.setCell(value);
                    break;
            }
        });
        return personService.getUsers(query);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {

        Person query = new Person();

        query.setId(id);

        return personService.getUser(query);
    }

    @PostMapping("/")
    public Person createPerson(@RequestBody Person person) {
        return personService.saveUser(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        Person query = new Person();

        query.setId(id);

        return personService.updateUser(query,person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        Person query = new Person();
        query.setId(id);
        personService.deleteUser(query);
    }
}
