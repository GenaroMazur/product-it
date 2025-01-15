package com.genaro.productosIt.entity;

import lombok.Data;

@Data
public class Product extends AbstractEntity {
    private Long id;
    private String name;
    private Double price;
    private  String description;
    private String photo;
}