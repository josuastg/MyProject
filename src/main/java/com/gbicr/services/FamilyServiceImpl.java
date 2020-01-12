package com.gbicr.services;

import com.gbicr.model.Family;
import com.gbicr.repositories.FamilyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    FamilyRepo familyRepo;
    @Override
    public Family findByid(Integer id) throws Exception {
        return familyRepo.findById(id).get();
    }

    @Override
    public List<Family> findAll() {
        return familyRepo.findAll();
    }

    @Override
    public Family save(Family family) {
        return familyRepo.save(family);
    }

    @Override
    public void remove(Integer id) {
        familyRepo.deleteById(id);

    }
}
