package com.example.demo.Enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    Up(0, "上架"),
    Down(1, "下架");

    private Integer code;

    private String messge;

    ProductStatusEnum(Integer code, String messge) {
        this.code = code;
        this.messge = messge;
    }
}
