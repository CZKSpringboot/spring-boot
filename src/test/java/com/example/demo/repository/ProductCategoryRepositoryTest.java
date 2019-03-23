package com.example.demo.repository;
import com.example.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import javax.transaction.Transactional;

/*  @RunWith(JUnit4.class)就是指用JUnit4来运行 @RunWith(JUnit4.class)就是指用JUnit4来运行 */
/* 使用这个类，简单注解一个JUnit 4 依赖的测试@RunWith(SpringRunner.class). */
@RunWith(SpringRunner.class)
/* 就能取到spring中的容器的实例，如果配置了@Autowired那么就自动将对象注入。 */
/* 需要在@SpringBootTest注解的参数classes中加入参数，表示将某些类纳入测试环境的容器中。 */
@SpringBootTest//j就是把demoRepository放进测试环境的容器中


public class ProductCategoryRepositoryTest {

    @Autowired

    private ProductCategoryRepository repository;


    /* @Test的使用 是该方法可以不用main方法调用就可以测试出运行结果，是一种测试方法
一般函数都需要有main方法调用才能执行，注意被测试的方法必须是public修饰的 */
    @Test

    public void findOneTest(){
/* 调用findById方法返回Optional对象，再调用Optional的get()方法返回该对象，
即用xxxRepository.findById(id).get()代替原来的findOne(id）方法。 */
        ProductCategory pc =  repository.findById(1).get();

        System.out.println(pc.toString());

    }

    @Test
    @Transactional
/* @Transactional注解，Test类中每个方法执行完之后都会默认清空虚拟数据库中的数据，
因此便不再需要每次执行完都要清空数据。  */
/* @Transactional事务注解，每次做完操作就完全回滚（仅限单元测试中）*/
    public void saveTest(){

        ProductCategory pc = new ProductCategory ("男生最爱",4);

        ProductCategory result = repository.save(pc);

/* Assert断言函数 */
/* Assert.assertNotNull是判断结果集是否为空 */
        Assert.assertNotNull(result);
/* Assert.assertNotEquals() ,第一个是不想得到的结果集，第二个是理想的结果集 */
//        Assert.assertNotEquals(null,result);
    }

//    @Test
//    public void update(){
//
//        ProductCategory pc = repository.findById(6).get();
//
//        pc.setCategory_type(3);
//
//        repository.save(pc);
//    }

    @Test
    public void findByCategoryTypeInTest(){

        List<Integer> list =Arrays.asList(2,3,4,5,6);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0,result.size());

    }

}