package com.wmb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wmb.model.Transaction;
import com.wmb.service.TransactionServices;

@RestController
@RequestMapping("/trans")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransactionCtrl {

	@Autowired
	TransactionServices transactionServices;

	@GetMapping("/")
	public List<Transaction> findAll() {
		return transactionServices.findAll();
	}

	@GetMapping("/paid")
	public List<Transaction> findAllPaid() {
		return transactionServices.findByStatus("Paid");
	}

	@GetMapping("/unpaid")
	public List<Transaction> findAllUnPaid() {
		return transactionServices.findByStatus("Unpaid");
	}

	@GetMapping("/{id}")
	public Transaction findById(@PathVariable Integer id) throws Exception {
		return transactionServices.findById(id);
	}

	@PostMapping("/")
	public Transaction create(@RequestBody Transaction transaction) throws Exception {
		return transactionServices.create(transaction);
	}

	@PatchMapping("/unpaid/{id}")
	public Transaction update(@PathVariable Integer id) throws Exception {
		Transaction trans = transactionServices.findById(id);
		if (trans == null) { throw new Exception("Id not found");
		}
		return transactionServices.update(trans);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		transactionServices.delete(id);
	}

}
