package com.example.demo.VO_viewObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品(包含类目)
 *
 */
@Data
public class ProductVO {

    /*@JsonProperty 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，
    如把trueName属性序列化为name，@JsonProperty("name")。*/
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


}
