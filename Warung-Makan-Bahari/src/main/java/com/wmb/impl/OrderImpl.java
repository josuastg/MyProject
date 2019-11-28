package com.wmb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wmb.model.Order;
import com.wmb.repository.OrderRepo;
import com.wmb.service.OrderServices;

@Service
public class OrderImpl implements OrderServices {

	@Autowired
	OrderRepo orderRepo;
	

	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	public Order findById(Integer id) throws Exception {
		if(findAll().isEmpty()) {
			throw new Exception("404 List Not Found");
		}else {
			for (int i = 0; i < findAll().size(); i++) {
				Order index = findAll().get(i);
				if (index.getId() == id) {
					return index;
				}
			}
		}
		throw new Exception("Eror 404 Id Not Found");
	}
	public Order save(Order order) {
		return orderRepo.save(order);
	}

	public void delete(Integer id) {
		orderRepo.deleteById(id);

	}

}
