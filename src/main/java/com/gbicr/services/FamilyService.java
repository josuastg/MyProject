package com.gbicr.services;

import com.gbicr.model.Family;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FamilyService {

    Family findByid(Integer id)throws Exception;
    List<Family> findAll();
    Family save(Family family);
    void remove(Integer id);
}
