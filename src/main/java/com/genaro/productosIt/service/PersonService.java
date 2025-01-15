package com.genaro.productosIt.service;

import com.genaro.productosIt.entity.RandomUser.RandomUser;
import com.genaro.productosIt.entity.Person;
import com.genaro.productosIt.expections.ResourceNotFoundException;
import com.genaro.productosIt.repository.PersonReposity;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonReposity personReposity;

    public Person getRandomUser() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://randomuser.me/api", String.class);

        Gson gson = new Gson();

        assert response != null;
        RandomUser randomUser = gson.fromJson(response, RandomUser.class);

        Person person = new Person();

        person.setName(randomUser.results.get(0).name.first);
        person.setLastName(randomUser.results.get(0).name.last);
        person.setEmail(randomUser.results.get(0).email);
        person.setPhone(randomUser.results.get(0).phone);
        person.setCell(randomUser.results.get(0).cell);

        return person;
    }

    public Person saveUser(Person person) {
        return personReposity.save(person);
    }

    public ArrayList<Person> getUsers(Person query) {
        return personReposity.find(query);
    }

    public void deleteUser(Person query) {
        personReposity.delete(query);
    }

    public Person updateUser(Person query, Person person) {
        return personReposity.update(query, person).orElseThrow(ResourceNotFoundException::new);
    }

    public Person getUser(Person query) {
        return personReposity.findOne(query).orElseThrow(ResourceNotFoundException::new);
    }
}
