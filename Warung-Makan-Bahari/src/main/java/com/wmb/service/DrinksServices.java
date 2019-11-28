package com.wmb.service;

import java.util.List;

import com.wmb.model.Drinks;


public interface DrinksServices {
	List<Drinks> findAll();
	Drinks findById(Integer id) throws Exception;
	Drinks save(Drinks drinks);
	void delete(Integer id);
}
