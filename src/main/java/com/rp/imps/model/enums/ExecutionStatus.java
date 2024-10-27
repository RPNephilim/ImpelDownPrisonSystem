package com.rp.imps.model.enums;

import lombok.Getter;

@Getter
public enum ExecutionStatus {
    TBD("to be decided"),
    SET("set"),
    NA("not set")
    ;

    private final String status;

    ExecutionStatus(String status){
        this.status = status;
    }
}
