package com.gbicr.services;

import com.gbicr.model.Gender;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GenderService {
    List<Gender> findAll();
}
