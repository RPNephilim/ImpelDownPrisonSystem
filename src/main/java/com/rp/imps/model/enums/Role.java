package com.rp.imps.model.enums;

import lombok.Getter;

@Getter
public enum Role {
    WARDEN("warden"),
    VICE_WARDEN("vice_warden"),
    LEVEL_SUPERVISOR("level_supervisor"),
    GUARD("guard")
    ;
    private final String name;

    Role(String name){
        this.name=name;
    }
}
