package com.gbicr.services;

import com.gbicr.model.StatusCongregation;
import com.gbicr.repositories.StatusCongregationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusCongregationServiceImpl implements StatusCongregationService {
    @Autowired
    StatusCongregationRepo statusCongregationRepo;

    @Override
    public List<StatusCongregation> findAll() {
        return statusCongregationRepo.findAll();
    }
}
