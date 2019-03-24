package com.example.demo.Service.impl;

import com.example.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {

        ProductCategory productCategory = categoryService.findOne(1);
//
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());

    }

    @Test
    public void findAll() throws Exception{

    List<ProductCategory> list = categoryService.findAll();

    Assert.assertNotEquals(0,list.size());

    }

    @Test
    public void findByCategoryTypeIn() {

        List list = Arrays.asList(1,2,3,4,5,6);

        List<ProductCategory> result = categoryService.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void save() {

        ProductCategory productCategory = categoryService.save(new ProductCategory("男生专享",4));

        ProductCategory result = categoryService.save(productCategory);

//        Assert.assertNotEquals(null,result);
        Assert.assertNotNull(result);

    }
}