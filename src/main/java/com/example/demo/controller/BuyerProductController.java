package com.example.demo.controller;

import com.example.demo.Service.CategoryService;
import com.example.demo.Service.ProductionInfoService;
import com.example.demo.Utils.ResultVOUnit;
import com.example.demo.VO_viewObject.ProductInfoVO;
import com.example.demo.VO_viewObject.ProductVO;
import com.example.demo.VO_viewObject.ResultVO;
import com.example.demo.dataobject.ProductCategory;
import com.example.demo.dataobject.ProductionInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*@RestController这个注解其实就是@ResponseBody和@Controller注解的组合而已*/
/*相当于整个类中所有方法的返回值都为json字符串 */
@RestController
/* @RequestMapping是Spring Web应用程序中最常被用到的注解之一。
这个注解会将HTTP请求映射到MVC和REST控制器的处理方法上。  */
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductionInfoService productionInfoService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){
//        1.查询所有的上架商品

        List<ProductionInfo> productionInfoList = productionInfoService.findUpAll();

//        System.out.println(productionInfoList.toString());

//        2.查询类目（一次性查询）
//        传统方法
//        List<Integer> categoryList = new ArrayList<>();
//
//        for (ProductionInfo productionInfo : productionInfoList){
//
//              categoryList.add(productionInfo.getCategoryType());
//
//        }
//        java8.0特性lambda

/*Stream（流）是一个来自数据源的元素队列并支持聚合操作
* 内部迭代： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代，
 * 这叫做外部迭代。 Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。
 * map
map 方法用于映射每个元素到对应的结果，
 collect 主要运用它的输出list
* */
        List<Integer> categoryTypeList = productionInfoList.stream().
                map(e -> e.getCategoryType()).
                collect(Collectors.toList());

//        System.out.println(categoryList.toString());

         List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

//        System.out.println(productCategoryList.toString());

//        3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList){

            ProductVO productVO = new ProductVO();

            productVO.setCategoryName(productCategory.getCategoryName());

            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            for (ProductionInfo productionInfo : productionInfoList) {

                if (productionInfo.getCategoryType().equals(productCategory.getCategoryType())) {

                    ProductInfoVO productInfoVO = new ProductInfoVO();

                    BeanUtils.copyProperties(productionInfo, productInfoVO);

                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);

            productVOList.add(productVO);
        }

//        System.out.println(productVOList.toString());

          return ResultVOUnit.success(productVOList);

    }



}
