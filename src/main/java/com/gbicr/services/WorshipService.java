package com.gbicr.services;

import com.gbicr.model.Worship;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WorshipService {
    List<Worship> findAll();
    void remove(Integer id);
    Worship findById(Integer id);
    Worship save(Worship worship);
}
