package com.genaro.productosIt.repository;

import com.genaro.productosIt.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class PersonReposity implements RepositoryI<Person> {
    private final ArrayList<Person> persons = new ArrayList<>();

    @Override
    public Person save(Person entity) {

        entity.setId(Person.getNewId());

        persons.add(entity);

        return entity;
    }

    @Override
    public void delete(Person entity) {
        persons.remove(entity);
    }

    @Override
    public ArrayList<Person> find(Person query) {
        return persons.stream().filter(person -> {

            if(query.getId() != null && !query.getId().equals(person.getId())) {
                return false;
            }

            if(query.getName() != null && !person.getName().toLowerCase().contains(query.getName().toLowerCase())) {
                return false;
            }

            if(query.getLastName() != null && !person.getLastName().toLowerCase().contains(query.getLastName().toLowerCase())) {
                return false;
            }

            if(query.getEmail() != null && !person.getEmail().toLowerCase().contains(query.getEmail().toLowerCase())) {
                return false;
            }

            if(query.getPhone() != null && !person.getPhone().toLowerCase().contains(query.getPhone().toLowerCase())) {
                return false;
            }

            if(query.getCell() != null && !person.getCell().toLowerCase().contains(query.getCell().toLowerCase())) {
                return false;
            }

            return true;
        }).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    }

    @Override
    public Optional<Person> update(Person query, Person entity) {
        Optional<Person> person = findOne(query);

        if(person.isPresent()) {
            person.get().setName(entity.getName());
            person.get().setLastName(entity.getLastName());
            person.get().setEmail(entity.getEmail());
            person.get().setPhone(entity.getPhone());
            person.get().setCell(entity.getCell());
        }

        return person;
    }

    @Override
    public Optional<Person> findOne(Person query) {
        return persons.stream().filter(person -> {
            if (query.getId() != null && !query.getId().equals(person.getId())) {
                return false;
            }
            if (query.getName() != null && !person.getName().toLowerCase().contains(query.getName().toLowerCase())) {
                return false;
            }
            if (query.getLastName() != null && !person.getLastName().toLowerCase().contains(query.getLastName().toLowerCase())) {
                return false;
            }
            if (query.getEmail() != null && !person.getEmail().toLowerCase().contains(query.getEmail().toLowerCase())) {
                return false;
            }
            if (query.getPhone() != null && !person.getPhone().toLowerCase().contains(query.getPhone().toLowerCase())) {
                return false;
            }
            if (query.getCell() != null && !person.getCell().toLowerCase().contains(query.getCell().toLowerCase())) {
                return false;
            }
            return true;
        }).findFirst();

    }
}