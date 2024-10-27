package com.rp.imps.model.entity;

import com.rp.imps.model.Person;
import com.rp.imps.model.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Role role;
    private String assignedArea;
    private String shift;
    private LocalDate joiningDate;
}
