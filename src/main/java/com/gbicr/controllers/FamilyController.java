package com.gbicr.controllers;

import com.gbicr.model.Family;
import com.gbicr.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    FamilyService familyService;

    @GetMapping("")
    public List<Family> findAll() {
        return familyService.findAll();
    }

    @GetMapping("{id}")
    public Family findById(@PathVariable Integer id) throws Exception {
        return familyService.findByid(id);
    }
    @PostMapping("")
    public  Family save(@RequestBody Family family){
        return familyService.save(family);
    }
    @DeleteMapping("{id}")
    public void remove(@PathVariable Integer id){
        familyService.remove(id);
    }
}
