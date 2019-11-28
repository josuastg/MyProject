package com.wmb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmb.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>  {
//	Transaksi findByid(Integer id);
	List<Transaction> findByStatus(String status);

}