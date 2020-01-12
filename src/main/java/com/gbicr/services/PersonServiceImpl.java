package com.gbicr.services;

import com.gbicr.model.Person;
import com.gbicr.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepo personRepo;

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }

    @Override
    public Person findById(Integer id) {
        return personRepo.findById(id).get();
    }

    @Override
    public void remove(Integer id) {
        personRepo.deleteById(id);
    }

    @Override
    public Person save(Person person) {
        return personRepo.save(person);
    }
}
