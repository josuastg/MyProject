package com.gbicr.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gbicr.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface PersonService {
    List<Person> findAll();
    Person createNewPerson(MultipartFile multipartFile,String person) throws JsonProcessingException;
    Person findById(Integer id);
    void remove (Integer id);
    Person save(Person person);
}
