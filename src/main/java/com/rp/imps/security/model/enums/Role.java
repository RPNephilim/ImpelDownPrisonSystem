package com.rp.imps.security.model.enums;

public enum Role {
    ROLE_WARDEN("warden", 0),
    ROLE_VICE_WARDEN("vice_warden", 1),
    ROLE_LEVEL_SUPERVISOR("level_supervisor", 2),
    ROLE_GUARD("guard", 3)
    ;

    Role(String name, int rank){

    }
    public int getRank(String name){
        return Role.valueOf(name).ordinal();
    }
}
