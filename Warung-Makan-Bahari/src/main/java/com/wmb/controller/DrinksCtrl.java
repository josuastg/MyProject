package com.wmb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wmb.model.Drinks;
import com.wmb.service.DrinksServices;

@RestController
@RequestMapping("/drinks")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DrinksCtrl {

	@Autowired
	DrinksServices drinksServices;

	@GetMapping("")
	public List<Drinks> findAll() {
		return drinksServices.findAll();
	}

	@GetMapping("{id}")
	public Drinks findById(@PathVariable Integer id) throws Exception {
		return drinksServices.findById(id);
	}

	@PostMapping("/")
	public Drinks create(@RequestBody Drinks drinks) {
		return drinksServices.save(drinks);
	}

	@PutMapping("{id}")
	public Drinks update(@RequestBody Drinks drinks,@PathVariable Integer id) {
		return drinksServices.save(drinks);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		drinksServices.delete(id);
	}
}
