package com.rp.imps.model.entity;

import com.rp.imps.model.Person;
import com.rp.imps.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Official extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "official-seq-gen")
    @SequenceGenerator(name = "official-seq-gen", initialValue = 1000, allocationSize = 1)
    private String id;
    private Role role;
    private String assignedArea;
    private String shift;
    private LocalDate joiningDate;
}
