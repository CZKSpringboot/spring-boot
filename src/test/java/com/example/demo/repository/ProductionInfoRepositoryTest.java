package com.example.demo.repository;

import com.example.demo.dataobject.ProductionInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductionInfoRepositoryTest {

    @Autowired
    private ProductionInfoRepository repository;

    @Test
    public void saveTest(){

        ProductionInfo productionInfo = new ProductionInfo();

        productionInfo.setProductId("123456");

        productionInfo.setProductName("白切鸡");

        productionInfo.setProductPrice(new BigDecimal(32.5));

        productionInfo.setProductStock(20);

        productionInfo.setProductDescription("好吃美味，在线等吃....");

        productionInfo.setProductIcon("http://*****.jpg");

        productionInfo.setProductStatus(0);

        productionInfo.setCategoryType(1);

        ProductionInfo result= repository.save(productionInfo);

        Assert.assertNotNull(result);

    }

    @Test
    public void findByProductStatus(){

       List<ProductionInfo> ProductionStatusList = repository.findByProductStatus(0);

       Assert.assertNotEquals(0,ProductionStatusList.size());

    }

}