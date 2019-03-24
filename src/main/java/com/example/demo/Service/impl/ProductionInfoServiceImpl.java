package com.example.demo.Service.impl;

import com.example.demo.Enums.ProductStatusEnum;
import com.example.demo.Service.ProductionInfoService;
import com.example.demo.dataobject.ProductionInfo;
import com.example.demo.repository.ProductionInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductionInfoServiceImpl implements ProductionInfoService{

    @Autowired
    private ProductionInfoRepository repository;


    @Override
    public ProductionInfo findOne(String productId) {
/**
 * get的源代码，这样写，抛出了NoSuchElementException异常，这个异常我们没法在全局中处理它。
 * orElse(Null)是避免空指针的问题
 */
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductionInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.Up.getCode());
    }

    @Override
    /**
     *
     * Page是Spring Data提供的一个接口，该接口表示一部分数据的集合以及其相关的下一部分数据、
     * 数据总数等相关信息，通过该接口，我们可以得到数据的总体信息（数据总数、总页数...）
     * 以及当前数据的信息（当前数据的集合、当前页数等）
     *
     * Pageable 是Spring Data库中定义的一个接口，该接口是所有分页相关信息的一个抽象，通过该接口，
     * 我们可以得到和分页相关所有信息（例如pageNumber、pageSize等）
     *
     * Pageable定义了很多方法，但其核心的信息只有两个：
     * 一是分页的信息（page、size）
     * 二是排序的信息。Spring Data Jpa提供了PageRequest的具体实现
     */
    public Page<ProductionInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductionInfo save(ProductionInfo productionInfo) {
        return repository.save(productionInfo);
    }
}