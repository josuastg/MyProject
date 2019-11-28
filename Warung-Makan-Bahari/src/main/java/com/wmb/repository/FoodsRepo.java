package com.wmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmb.model.Foods;

public interface FoodsRepo extends JpaRepository<Foods, Integer>  {
	Foods findByid(Integer id);
}
