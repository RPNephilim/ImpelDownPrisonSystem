package com.rp.imps.model.entity;

import com.rp.imps.model.enums.LevelType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LevelType type;
    private String supervisor;
    private List<Area> areas;
}
