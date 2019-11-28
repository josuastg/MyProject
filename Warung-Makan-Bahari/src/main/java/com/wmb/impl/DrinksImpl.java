package com.wmb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmb.model.Drinks;
import com.wmb.repository.DrinksRepo;
import com.wmb.service.DrinksServices;

@Service
public class DrinksImpl implements DrinksServices {
	
	@Autowired
	DrinksRepo drinksRepo;
	
	public List<Drinks> findAll() {
		return drinksRepo.findAll();
	}

	public Drinks findById(Integer id) throws Exception {
		if (findAll().isEmpty()) {
			throw new Exception("404 List Not Found");
		} else {
			for (int i = 0; i < findAll().size(); i++) {
				Drinks index = findAll().get(i);
				if (index.getId() == id) {
					return index;
				}
			}
		}
		throw new Exception("Eror 404 Id Not Found");
	}
	public Drinks save(Drinks drinks) {
		return drinksRepo.save(drinks);
	}

	public void delete(Integer id) {
		drinksRepo.deleteById(id);
	}
}
