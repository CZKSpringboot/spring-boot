package com.example.demo.Service.impl;

import com.example.demo.Service.CategoryService;
import com.example.demo.dataobject.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/* @Service用于标注业务层组件 */
@Service
public class CategoryServiceImpl implements CategoryService {
/*  @Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作  */
/* 通过@Autowired获取Service层的Bean对象； */
    @Autowired
    private   ProductCategoryRepository repository ;

    @Override
//    @PostConstruct
    public ProductCategory findOne(Integer categoryId) {

        /**
         * 查不到返回null
         * .get 抛异常
         */
        return  repository.findById(categoryId).orElse(null);

    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {

        return repository.save(productCategory);
    }
}
