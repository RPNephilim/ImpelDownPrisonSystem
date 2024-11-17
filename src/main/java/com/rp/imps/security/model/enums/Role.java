package com.rp.imps.security.model.enums;

public enum Role {
    ROLE_WARDEN("WARDEN", 0),
    ROLE_VICE_WARDEN("VICE_WARDEN", 1),
    ROLE_LEVEL_SUPERVISOR("LEVEL_SUPERVISOR", 2),
    ROLE_GUARD("GUARD", 3)
    ;

    Role(String name, int rank){

    }
    public int getRank(String name){
        return Role.valueOf(name).ordinal();
    }

    public String getName(){
        return name();
    }
}
