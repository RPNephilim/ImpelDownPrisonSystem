package com.rp.imps.model.request;

import com.rp.imps.model.entity.Official;
import jakarta.persistence.ElementCollection;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreaRequest {
    private String name;
    private List<String> cells;
    private List<String> rooms;
    private List<Official> guardsAssigned;
}
