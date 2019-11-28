package com.wmb;


import com.wmb.model.Tables;
import com.wmb.repository.TableRepo;
import com.wmb.service.TableServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableServicesImplMockTest {

    @MockBean
    TableRepo dao;

    @Autowired
    TableServices tableServices;

    Tables newtables = new Tables(57, "A3", 4, "AVAILABLE");

    @Before
    public  void init (){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void CreateTable_ShouldBeReturnTable(){
        tableServices.save(newtables);

        verify(dao, times(1)).save(newtables);
    }



}
