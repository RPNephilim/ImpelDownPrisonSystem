package com.rp.imps.model.request;

import com.rp.imps.model.enums.DevilFruitType;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevilFruitRequest {
    private String type;
    private String name;
    private String alternateName;
    private String powerDescription;
}
