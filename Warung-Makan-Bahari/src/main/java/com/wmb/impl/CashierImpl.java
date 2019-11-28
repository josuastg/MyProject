package com.wmb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmb.model.Cashier;
import com.wmb.repository.CashierRepo;
import com.wmb.service.CashierServices;

@Service
public class CashierImpl implements CashierServices {

	@Autowired
	CashierRepo cashierRepo;

	public Cashier findById(Integer id) throws Exception {
		if (findAll().isEmpty()) {
			throw new Exception("404 List Not Found");
		} else {
			for (int i = 0; i < findAll().size(); i++) {
				Cashier index = findAll().get(i);
				if (index.getId() == id) {
					return index;
				}
			}
		}
		throw new Exception("Eror 404 Id Not Found");
	}

	public List<Cashier> findAll() {
		return cashierRepo.findAll();
	}

}
