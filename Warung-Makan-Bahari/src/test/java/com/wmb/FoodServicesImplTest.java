package com.wmb;

import com.wmb.model.Foods;
import com.wmb.model.Tables;
import com.wmb.repository.FoodsRepo;
import com.wmb.service.FoodsServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


import static junit.framework.Assert.*;
import static org.junit.Assert.assertArrayEquals;

    @RunWith(SpringRunner.class)
    @SpringBootTest
    @Transactional
    public class FoodServicesImplTest {


    @Autowired
    FoodsServices foodsServices;
    @Autowired
    FoodsRepo foodsRepo;

    Foods newFoods = new Foods(1, "Pie", 10000, 50);

    @Test
    public void saveFood_shouldBeReturnFood() throws Exception {
        Foods expected = foodsServices.save(newFoods);
        assertNotNull(foodsRepo.findById(expected.getId()).get());
        assertEquals(expected, foodsRepo.findById(expected.getId()).get());

    }

    @Test
    public void findList_shouldBeReturnFoodList() {
        List<Foods> listServices = foodsServices.findAll();
        //        foodsServices.save(newFoods);
        List<Foods> listRepo = foodsRepo.findAll();
        assertArrayEquals(listServices.toArray(), listRepo.toArray());
    }

    @Test
    public void deleteFood_shouldBeReturnFood() {
        Foods food = foodsServices.save(newFoods);
        foodsServices.delete(food.getId());
        List<Foods> listFoodsService = foodsServices.findAll();
        List<Foods> listFoodsRepo = foodsRepo.findAll();
        assertEquals(listFoodsService.size(), listFoodsRepo.size());
    }

    @Test
    public void findFood_shouldBeReturnFoods() throws Exception {
        Foods expected = foodsServices.save(newFoods);
        assertEquals(expected, foodsRepo.findById(expected.getId()).get());
    }

    @Test
    public void findFoodById_shouldBeReturnFood() throws Exception {
        Foods saveFood = foodsServices.save(newFoods);
        Foods food = foodsRepo.findById(saveFood.getId()).get();
        assertEquals("Pie", food.getName());
        assertSame(50, food.getStock());
    }


}
