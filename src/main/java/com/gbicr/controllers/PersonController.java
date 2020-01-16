package com.gbicr.controllers;
import com.gbicr.model.Person;
import com.gbicr.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/person/{id}")
    public Person findById(@PathVariable Integer id) throws Exception {
        return personService.findById(id);
    }
    @PostMapping("/person")
    public  Person save(@RequestBody Person person){
        return personService.save(person);
    }

    @DeleteMapping("/person/{id}")
    public void remove(@PathVariable Integer id){
        personService.remove(id);
    }

}
