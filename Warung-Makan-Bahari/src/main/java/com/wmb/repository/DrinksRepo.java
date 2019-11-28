package com.wmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmb.model.Drinks;

public interface DrinksRepo extends JpaRepository<Drinks, Integer>  {
	Drinks findByid(Integer id);
}
