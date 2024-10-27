package com.rp.imps.model.entity;

import com.rp.imps.model.enums.DevilFruitType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DevilFruit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private DevilFruitType type;
    private String name;
    private String alternateName;
    private String powerDescription;
}
