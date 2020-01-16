package com.gbicr.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbicr.model.Person;
import com.gbicr.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepo personRepo;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }

    @Override
    public Person createNewPerson(MultipartFile multipartFile, String requestBody) throws JsonProcessingException {
        Person person= save(objectMapper.readValue(requestBody, Person.class));
        File file = new File("");

        return person;
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
