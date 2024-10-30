package com.rp.imps.model.response;

import com.rp.imps.model.Person;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfficialResponse extends Person {
    private String id;
    private String role;
    private String assignedArea;
    private String shift;
    private String joiningDate;
}
