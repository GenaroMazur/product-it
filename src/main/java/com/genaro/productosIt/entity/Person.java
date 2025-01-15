package com.genaro.productosIt.entity;

import lombok.Data;

@Data
public class Person {
    static private Long idCounter = 0L;
    static public Long getNewId(){
        return idCounter++;
    }

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String cell;
}
