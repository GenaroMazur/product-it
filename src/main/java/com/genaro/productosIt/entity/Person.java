package com.genaro.productosIt.entity;

import lombok.Data;

@Data
public class Person extends AbstractEntity{

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String cell;
}
