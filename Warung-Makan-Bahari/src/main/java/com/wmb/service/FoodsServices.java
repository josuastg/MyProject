package com.wmb.service;

import java.util.List;

import com.wmb.model.Foods;


public interface FoodsServices {
	List<Foods> findAll();
	Foods findById(Integer id) throws Exception;
	Foods save(Foods foods);
	void delete(Integer id);
}
