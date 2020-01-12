package com.gbicr.services;

import com.gbicr.model.StatusPerson;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StatusPersonService {
    public List<StatusPerson> findAll();
}
