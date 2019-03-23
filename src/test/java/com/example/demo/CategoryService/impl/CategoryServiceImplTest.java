package com.example.demo.CategoryService.impl;

import com.example.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    private CategoryServiceImpl categoryService;

    @Test
    public void findById() {

        ProductCategory productCategory = categoryService.findById(1);
//
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());

    }

    @Test
    public void findAll() throws Exception{

    List<ProductCategory> list = categoryService.findAll();

    Assert.assertEquals(0,list.size());

    }

    @Test
    public void findByCategoryTypeIn() {

        List list = Arrays.asList(1,2,3,4,5,6);

//        ProductCategory productCategory = categoryService.findByCategoryTypeIn(list);
    }

    @Test
    public void save() {
//        save
    }
}