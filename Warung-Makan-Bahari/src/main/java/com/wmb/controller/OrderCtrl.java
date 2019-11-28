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

import com.wmb.model.Order;
import com.wmb.service.OrderServices;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderCtrl {

	@Autowired
	OrderServices orderServices;

	@GetMapping("")
	public List<Order> findAll() {
		return orderServices.findAll();
	}

	@GetMapping("{id}")
	public Order findById(@PathVariable Integer id) throws Exception {
		return orderServices.findById(id);
	}

	@PutMapping("{id}")
	public Order update(@RequestBody @PathVariable Order order) {
		return orderServices.save(order);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		orderServices.delete(id);
	}

	@PostMapping("")
	public Order create(@RequestBody Order order) {
		return orderServices.save(order);
	}

}
