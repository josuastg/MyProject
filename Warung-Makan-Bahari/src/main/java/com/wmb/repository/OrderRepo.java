package com.wmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmb.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>  {
}

