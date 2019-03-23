package com.example.demo.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/*加入 @ Entity注解，映射成对象*/
@Entity
/* 动态更新时间 */
@DynamicUpdate
/* @Data(lombok) 可以自动生成get和set方法，包括tostring方法 */
@Data
public class ProductCategory {
    /*  类目ID */
    /* 加入@ID 设置主键*/
    @Id
    /* 加入@ GeneratedValue 设置自增*/
/* @GeneratedValue 等价于 @GeneratedValue(strategy = GenerationType.AUTO) */
/* GenerationType.IDENTITY
多数数据库支持IDENTITY列，数据库会在新行插入时自动给ID赋值，这也叫做ID自增长列 */

/* GenerationType.Auto
把主键生成策略交给JPA厂商(Persistence Provider)，
由它根据具体的数据库选择合适的策略，可以是Table/Sequence/Identity中的一种 */

/*  */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /* 类目名字 */
    private String categoryName;
    /* 类目编号 */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
/* @Override 帮助自己检查是否正确的复写了父类中已有的方法
  告诉读代码的人，这是一个复写的方法 */
//    @Override
//    public String toString() {
//        return "ProductCategory{" +
//                "category_id=" + category_id +
//                ", category_name='" + category_name + '\'' +
//                ", category_type=" + category_type +
//                '}';
//    }


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, int categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
