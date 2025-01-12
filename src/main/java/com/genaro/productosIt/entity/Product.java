package com.genaro.productosIt.entity;

import lombok.Data;

@Data
public class Product {
    private static Long autoIncrement = 0L;

    private Long id;
    private String name;
    private Double price;
    private  String description;
    private String photo;

    public static Long getAutoIncrement() {
        autoIncrement++;
        return autoIncrement;
    }
}