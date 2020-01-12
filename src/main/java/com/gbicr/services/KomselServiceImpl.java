package com.gbicr.services;


import com.gbicr.model.Komsel;
import com.gbicr.repositories.KomselRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomselServiceImpl implements KomselService {

    @Autowired
    KomselRepo komselRepo;

    @Override
    public Komsel findByid(Integer id) throws Exception {
        return komselRepo.findById(id).get();
    }

    @Override
    public List<Komsel> findAll() {
        return komselRepo.findAll();
    }

    @Override
    public Komsel save(Komsel komsel) {
        return komselRepo.save(komsel);
    }

    @Override
    public void remove(Integer id) {
        komselRepo.deleteById(id);
    }


}

