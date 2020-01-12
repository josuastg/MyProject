package com.gbicr.services;

import com.gbicr.model.StatusCongregation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatusCongregationService {
    List<StatusCongregation> findAll();

}
