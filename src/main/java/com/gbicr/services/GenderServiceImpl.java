package com.gbicr.services;

import com.gbicr.model.Gender;
import com.gbicr.repositories.GenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    GenderRepo genderRepo;
    @Override
    public List<Gender> findAll() {
        return genderRepo.findAll();
    }
}
