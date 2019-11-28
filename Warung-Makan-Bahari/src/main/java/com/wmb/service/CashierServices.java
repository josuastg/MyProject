package com.wmb.service;

import java.util.List;
import com.wmb.model.Cashier;

public interface CashierServices {
	Cashier findById(Integer id) throws Exception;
	List<Cashier> findAll();
}
