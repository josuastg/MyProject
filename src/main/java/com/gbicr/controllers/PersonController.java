package com.gbicr.controllers;

import com.gbicr.model.Komsel;
import com.gbicr.model.Person;
import com.gbicr.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("")
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("{id}")
    public Person findById(@PathVariable Integer id) throws Exception {
        return personService.findById(id);
    }
    @PostMapping("")
    public  Person save(@RequestBody Person person){
        return personService.save(person);
    }
    @DeleteMapping("{id}")
    public void remove(@PathVariable Integer id){
        personService.remove(id);
    }

}
