package com.gbicr.services;

import com.gbicr.model.Komsel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface KomselService {
    Komsel findByid(Integer id)throws Exception;
    List<Komsel> findAll();
    Komsel save(Komsel komsel);
    void remove(Integer id);

}
