package com.gbicr.controllers;

import com.gbicr.model.StatusPerson;
import com.gbicr.services.StatusPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status-person")
public class StatusPersonController {
    @Autowired
    StatusPersonService statusPersonService;

    @GetMapping("")
    public List<StatusPerson> findAll(){
        return statusPersonService.findAll();
    }

}
