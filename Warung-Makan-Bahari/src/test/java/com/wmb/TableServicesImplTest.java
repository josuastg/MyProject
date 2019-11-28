package com.wmb;
import com.wmb.model.Tables;
import com.wmb.repository.TableRepo;
import com.wmb.service.TableServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableServicesImplTest {
//    @InjectMocks
//    TableImpl tableServices;
//
//    @Mock
//    TableRepo dao;

    @Autowired
    TableServices tableServices;

    @Autowired
    TableRepo tableRepo;


    Tables newtables = new Tables(57, "A3", 4, "AVAILABLE");

    @Test
    public  void SaveTable_shouldBeReturnTable() throws Exception {
        Tables expected  = tableServices.save(newtables);
        assertNotNull(tableRepo.findById(expected.getId()).get());
        assertEquals(expected, tableRepo.findById(expected.getId()).get());
    }

    @Test
    public void findTable_ShouldBeReturnTable () throws Exception {
        Tables expected = tableServices.save(newtables);
        assertEquals(expected, tableRepo.findById(expected.getId()).get());
    }

    @Test
    public void findList_shouldBeReturnListTable (){
        List<Tables> tablesRepo = tableRepo.findAll();
        List<Tables> tablesServices = tableServices.findAll();
        assertArrayEquals(tablesRepo.toArray(),tablesServices.toArray());
    }
    @Test
    public void deleteTableInList_shouldBeReturnListTable(){
        Tables saveTable = tableServices.save(newtables);
        tableServices.delete(saveTable.getId());
        List<Tables> listTableServices = tableServices.findAll();
        List<Tables> listTableRepo = tableRepo.findAll();
        assertEquals(listTableServices.size(), listTableRepo.size());
        //agar nilainya true makan expected harus dikurangi 1
    }

    @Test
    public void findTableById_ShouldBeReturnTable() throws Exception {
        Tables tables = tableServices.save(newtables);
        Tables findTable =tableRepo.findById(tables.getId()).get();
        assertEquals("A3", findTable.getName());
        assertSame(4, findTable.getCapacity());
        assertEquals("AVAILABLE", findTable.getStatus());
    }



//    @Test
//    public void findByIdTable_ShouldBeReturnNull() throws Exception {
//
//        Tables findIdTable = tableServices.findById(100);
//        assertNull(findIdTable);
//    }







}
