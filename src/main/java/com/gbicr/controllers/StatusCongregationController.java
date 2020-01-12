package com.gbicr.controllers;


import com.gbicr.model.StatusCongregation;
import com.gbicr.services.StatusCongregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status-congregation")
public class StatusCongregationController {

    @Autowired
    StatusCongregationService statusCongregationService;

    @GetMapping("")
    public List<StatusCongregation> findAll(){
        return statusCongregationService.findAll();
    }
}
