package com.example.demo.VO_viewObject;

import lombok.Data;

/**
 * Http请求返回的最外层对象
 *
 */
@Data
public class ResultVO <T>{
    /** 错误码 */
    private Integer code;
    /** 提示信息 */
    private String massge;
    /** 详细内容 */
    private T Data;


}
