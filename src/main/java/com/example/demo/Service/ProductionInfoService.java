package com.example.demo.Service;

import com.example.demo.dataobject.ProductionInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 * 陈子康
 */

/* 在Service层调用XxxxRepository接口与XxxxDao接口完成相应的业务逻辑 */
public interface ProductionInfoService {

    ProductionInfo findOne(String productId);

    /**
     * 查找所以在线商品
     */
    List<ProductionInfo> findUpAll ();

    Page<ProductionInfo> findAll(Pageable pageable);

    ProductionInfo save(ProductionInfo productionInfo);





}
