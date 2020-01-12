package com.gbicr.controllers;

import com.gbicr.model.Worship;
import com.gbicr.services.WorshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worship")
public class WorshipController {

    @Autowired
    WorshipService worshipService;

    @GetMapping("")
    public List<Worship> findAll(){
        return worshipService.findAll();
    }

    @GetMapping("{id}")
    public Worship findById(@PathVariable Integer id) throws Exception {
        return worshipService.findById(id);
    }
    @PostMapping("")
    public  Worship save(@RequestBody Worship worship){
        return worshipService.save(worship);
    }
    @DeleteMapping("{id}")
    public void remove(@PathVariable Integer id){
        worshipService.remove(id);
    }

}
