package com.rp.imps.model.response;

import com.rp.imps.model.Person;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrisonerResponse extends Person {
    private String id;
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
