package com.gbicr.repositories;

import com.gbicr.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepo extends JpaRepository<Gender, Integer> {
}
