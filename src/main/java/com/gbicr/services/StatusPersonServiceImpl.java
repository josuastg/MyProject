package com.gbicr.services;

import com.gbicr.model.StatusPerson;
import com.gbicr.repositories.StatusPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusPersonServiceImpl implements StatusPersonService {
    @Autowired
    StatusPersonRepo statusPersonRepo;

    @Override
    public List<StatusPerson> findAll() {
        return statusPersonRepo.findAll();
    }
}
