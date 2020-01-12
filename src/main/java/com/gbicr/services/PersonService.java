package com.gbicr.services;

import com.gbicr.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    List<Person> findAll();
    Person findById(Integer id);
    void remove (Integer id);
    Person save(Person person);
}
