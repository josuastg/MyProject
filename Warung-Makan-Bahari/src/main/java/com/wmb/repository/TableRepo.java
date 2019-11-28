package com.wmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wmb.model.Tables;


public interface TableRepo extends JpaRepository<Tables, Integer>  {}

