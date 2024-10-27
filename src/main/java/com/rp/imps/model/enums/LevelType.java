package com.rp.imps.model.enums;

import lombok.Getter;

@Getter
public enum LevelType {
    ONE(1, "BASIC"),
    TWO(2, "SNOWY"),
    THREE(3, "HOT"),
    FOUR(4, ""),
    FIVE(5, ""),
    SIX(6, "")
    ;

    private final int number;
    private final String description;

    LevelType(int number, String description){
        this.number=number;
        this.description=description;
    }

}
