package com.rp.imps.model.entity;

import com.rp.imps.model.enums.ExecutionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Prisoner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prisoner-seq-gen")
    @SequenceGenerator(name = "prisoner-seq-gen", initialValue = 10000, allocationSize = 1)
    private String id;
    private double bounty;
    private String crimeDescription;
    private String affiliatedWith;
    private String assignedLevel;
    private LocalDate executionDate;
    private ExecutionStatus executionStatus;
    private String assignedCell;
    private LocalDate entryDate;
}
