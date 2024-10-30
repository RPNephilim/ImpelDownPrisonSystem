package com.rp.imps.model.request;

import com.rp.imps.model.Person;
import com.rp.imps.model.enums.ExecutionStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrisonerRequest  extends Person {
    private double bounty;
    private String crimeDescription;
    private String affiliatedWith;
    private String assignedLevel;
    private String executionDate;
    private String executionStatus;
    private String assignedCell;
    private String entryDate;
}
