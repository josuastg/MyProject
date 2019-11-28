package com.wmb;

import com.wmb.model.Drinks;
import com.wmb.model.Foods;
import com.wmb.repository.DrinksRepo;
import com.wmb.service.DrinksServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DrinkServicesImplTest {

    @Autowired
    DrinksRepo drinksRepo;

    @Autowired
    DrinksServices drinksServices;

    Drinks newDrink = new Drinks(1, "Tea", 3000,50);

   @Test
    public void saveDrink_shouldBeReturnDrink () throws Exception {
        Drinks expected = drinksServices.save(newDrink);
        assertNotNull(drinksRepo.findById(expected.getId()).get());
        assertEquals(expected, drinksRepo.findById(expected.getId()).get());

    }
    @Test
    public void deleteDrink_shouldBeReturnDrink (){
       Drinks drink = drinksServices.save(newDrink);
       drinksServices.delete(drink.getId());
        List<Drinks> listDrinksService = drinksServices.findAll();
        List<Drinks> listDrinkRepo = drinksRepo.findAll();
        assertEquals(listDrinksService.size(),listDrinkRepo.size());
    }
    @Test
    public void findDrink_shouldBeReturnDrink(){
    Drinks expected = drinksServices.save(newDrink);
    assertEquals(expected, drinksRepo.findById(expected.getId()).get());

    }
    @Test
    public void findList_shouldBeReturnDrink(){
       List<Drinks> listService = drinksServices.findAll();
       List<Drinks> listRepo = drinksRepo.findAll();
       assertArrayEquals(listService.toArray(),listRepo.toArray());
    }
    @Test
    public void findDrinkById_shouldBeReturnDrink(){
        Drinks saveDrink = drinksServices.save(newDrink);
        Drinks drink = drinksRepo.findById(saveDrink.getId()).get();
        assertEquals("Tea" , drink.getName());
        assertSame(50, drink.getStock());

    }



}
