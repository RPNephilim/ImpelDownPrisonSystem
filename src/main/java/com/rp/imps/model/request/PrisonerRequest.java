package com.rp.imps.model.request;

import com.rp.imps.model.Person;
import lombok.*;

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
    private String assignedArea;
    private String executionDate;
    private String executionStatus;
    private String assignedCell;
    private String entryDate;
}
