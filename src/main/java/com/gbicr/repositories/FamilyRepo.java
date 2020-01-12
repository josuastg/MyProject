package com.gbicr.repositories;

import com.gbicr.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepo extends JpaRepository<Family, Integer> {
}
