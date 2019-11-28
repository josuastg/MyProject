package com.wmb.service;

import java.util.List;

import com.wmb.model.Order;

public interface OrderServices {
		List<Order> findAll();
		Order findById(Integer id) throws Exception;
		Order save(Order order);
		void delete(Integer id);
}
