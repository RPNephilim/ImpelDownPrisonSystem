package com.rp.imps.model.enums;

import lombok.Getter;

@Getter
public enum DevilFruitType {
    PARAMECIA("Paramecia"),
    LOGIA("Logia"),
    ZOAN("Zoan")
    ;

    private final String name;

    DevilFruitType(String name){
        this.name=name;
    }
}
