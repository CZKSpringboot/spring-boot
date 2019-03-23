package com.example.demo.repository;

import com.example.demo.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* 自定义的 XxxxRepository 需要继承 JpaRepository，这样的 XxxxRepository 接口就具备了通用的数据访问控制层的能力。 */
/* 继承标记接口Respository,必须给出实体类名和主键类型 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
/* Hibernate 使用CategoryType 来查询一组数据
需要在接口里定义一个接口，注意此接口必须符合一定的格式 */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}

