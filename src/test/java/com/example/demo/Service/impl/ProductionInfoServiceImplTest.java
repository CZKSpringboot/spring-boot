package com.example.demo.Service.impl;


import com.example.demo.Enums.ProductStatusEnum;
import com.example.demo.dataobject.ProductionInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductionInfoServiceImplTest {

    @Autowired
    private ProductionInfoServiceImpl productionInfoService;

    @Test
    public void findOne() {

        ProductionInfo result = productionInfoService.findOne("123456");

        Assert.assertEquals("123456",result.getProductId());

    }

    @Test
    public void findUpAll() {

        List<ProductionInfo> productionInfos = productionInfoService.findUpAll();

        Assert.assertNotEquals(0,productionInfos.size());

    }

    @Test
    public void findAll() {
/**
 * SpringbootJPA分页 PageRequest过时的办法
 */
//        PageRequest pageRequest = new PageRequest(0,5);
        PageRequest pageRequest=PageRequest.of(0,5);

        Page<ProductionInfo> productionInfoPage = productionInfoService.findAll(pageRequest);
//getTotalElements 是查看全部page的全部元素
//        System.out.println(productionInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productionInfoPage.getTotalElements());
    }

    @Test
    public void save() {

        ProductionInfo productionInfo = new ProductionInfo();

        productionInfo.setProductId("123457");

        productionInfo.setProductName("清蒸鱼头");

        productionInfo.setProductPrice(new BigDecimal(25.5));

        productionInfo.setProductStock(15);

        productionInfo.setProductDescription("好吃美味，在线等吃....");

        productionInfo.setProductIcon("http://*****.jpg");

        productionInfo.setProductStatus(ProductStatusEnum.Down.getCode());

        productionInfo.setCategoryType(1);

        ProductionInfo result= productionInfoService.save(productionInfo);

        Assert.assertNotNull(result);

    }
}