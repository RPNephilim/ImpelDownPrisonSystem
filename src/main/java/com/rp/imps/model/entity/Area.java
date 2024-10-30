package com.rp.imps.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area-seq-gen")
    @SequenceGenerator(name = "area-seq-gen", initialValue = 100000, allocationSize = 1)
    private String id;
    private String name;
    private List<String> cells;
    private List<String> rooms;
    @ElementCollection
    private List<Official> guardsAssigned;
}
