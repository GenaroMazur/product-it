package com.genaro.productosIt.entity;

import lombok.Data;

@Data
abstract public class AbstractEntity {
    static private Long idCounter = 0L;
    static public Long getNewId(){
        return idCounter++;
    }

    private Long id;
}
