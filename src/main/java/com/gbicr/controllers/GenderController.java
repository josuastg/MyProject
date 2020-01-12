package com.gbicr.controllers;

import com.gbicr.model.Gender;
import com.gbicr.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    GenderService genderService;

    @GetMapping("")
    public List<Gender> findAll(){
        return  genderService.findAll();
    }


}
