package com.example.demo.repository;

import com.example.demo.dataobject.ProductionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductionInfoRepository extends JpaRepository <ProductionInfo, String> {

    List<ProductionInfo> findByProductStatus(Integer productionStatus);

}
