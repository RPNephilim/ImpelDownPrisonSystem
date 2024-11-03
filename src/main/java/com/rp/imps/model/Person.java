package com.rp.imps.model;

import com.rp.imps.model.entity.DevilFruit;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private String fullName;
    private String fatherName;
    private String motherName;
    private String race;
    private DevilFruit devilFruit;
    private String photo;
}
