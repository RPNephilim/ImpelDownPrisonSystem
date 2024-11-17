package com.rp.imps.model;

import com.rp.imps.model.entity.DevilFruit;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String fullName;
    private String fatherName;
    private String motherName;
    private String race;
    private String devilFruit;
    private String photo;
}
