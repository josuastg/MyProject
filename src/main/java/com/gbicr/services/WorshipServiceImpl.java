package com.gbicr.services;

import com.gbicr.model.Worship;
import com.gbicr.repositories.WorshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorshipServiceImpl implements WorshipService {
    @Autowired
    WorshipRepo worshipRepo;

    @Override
    public List<Worship> findAll() {
        return worshipRepo.findAll();
    }

    @Override
    public void remove(Integer id) {
        worshipRepo.deleteById(id);
    }

    @Override
    public Worship findById(Integer id) {
        return worshipRepo.findById(id).get();
    }

    @Override
    public Worship save(Worship worship) {
        return worshipRepo.save(worship);
    }
}
