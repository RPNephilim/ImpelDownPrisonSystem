package com.rp.imps.model.response;

import com.rp.imps.model.entity.Official;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreaResponse {
    private String id;
    private String name;
    private List<String> cells;
    private List<String> rooms;
    private List<Official> guardsAssigned;
}
