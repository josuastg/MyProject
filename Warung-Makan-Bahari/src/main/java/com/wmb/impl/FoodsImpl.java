package com.wmb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmb.model.Foods;
import com.wmb.repository.FoodsRepo;
import com.wmb.service.FoodsServices;

@Service
public class FoodsImpl implements FoodsServices {

	@Autowired
	FoodsRepo foodsRepo;

	public List<Foods> findAll() {
		return foodsRepo.findAll();
	}

	public Foods findById(Integer id) throws Exception {
		if (findAll().isEmpty()) {
			throw new Exception("404 List Not Found");
		} else {
			for (int i = 0; i < findAll().size(); i++) {
				Foods index = findAll().get(i);
				if (index.getId() == id) {
					return index;
				}
			}
		}
		throw new Exception("Eror 404 Id Not Found");
	}

	public Foods save(Foods foods) {
		return foodsRepo.save(foods);
	}

	public void delete(Integer id) {
		foodsRepo.deleteById(id);
	}
}
