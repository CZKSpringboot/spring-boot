package com.example.demo.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class ProductionInfo {

    @Id
    private  String productId;
//'商品名称',
    private  String productName;
/* Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算。
双精度浮点型变量double可以处理16位有效数 */
//'商品单价'
    private BigDecimal productPrice;
//'库存'
    private Integer productStock;
//'描述'
    private String productDescription;
//'小图片'
    private  String productIcon;
// 状态，0正常1下架
    private Integer productStatus;
//'类目 '
    private  Integer categoryType;
//   '创建时间'
    private Date createTime;
//    更新时间
    private Date updateTime;

}
