package com.gbicr.controllers;

import com.gbicr.model.Komsel;
import com.gbicr.services.KomselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/komsel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class KomselController {

    @Autowired
    KomselService komselService;

    @GetMapping("")
    public List<Komsel> findAll() {
        return komselService.findAll();
    }

    @GetMapping("{id}")
    public Komsel findById(@PathVariable Integer id) throws Exception {
        return komselService.findByid(id);
    }
    @PostMapping("")
    public  Komsel save(@RequestBody Komsel komsel){
        return komselService.save(komsel);
    }
    @DeleteMapping("{id}")
    public void remove(@PathVariable Integer id){
        komselService.remove(id);
    }


}
