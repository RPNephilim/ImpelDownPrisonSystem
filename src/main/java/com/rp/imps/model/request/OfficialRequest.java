package com.rp.imps.model.request;

import com.rp.imps.model.Person;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfficialRequest extends Person {
    private String role;
    private String assignedArea;
    private String shift;
    private String joiningDate;
}
