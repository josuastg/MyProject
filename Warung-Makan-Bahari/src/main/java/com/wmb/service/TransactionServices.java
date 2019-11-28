package com.wmb.service;

import java.util.List;
import com.wmb.model.Transaction;

public interface TransactionServices {
	List<Transaction> findAll();
	List<Transaction> findByStatus(String status);
	Transaction findById(Integer id) throws Exception;
	Transaction create(Transaction transaction) throws Exception;
	Transaction update(Transaction transaction) throws Exception;
	void delete(Integer id);
}
