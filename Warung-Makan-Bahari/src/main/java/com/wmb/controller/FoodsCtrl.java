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

import com.wmb.model.Foods;
import com.wmb.service.FoodsServices;

@RestController
@RequestMapping("/foods")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FoodsCtrl {
	
	@Autowired
	FoodsServices foodsServices;
	
	@GetMapping("")
	public List<Foods> findAll() {
		return foodsServices.findAll();
	}
	
	@GetMapping("{id}")
	public Foods findById(@PathVariable Integer id) throws Exception {
		return foodsServices.findById(id);
	}
	
	@PostMapping("/")
	public Foods create(@RequestBody Foods foods) {
		return foodsServices.save(foods);
	}
	
	@PutMapping("{id}")
	public Foods update(@RequestBody Foods foods, @PathVariable Integer id) {
		return foodsServices.save(foods);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		foodsServices.delete(id);
	}
}
