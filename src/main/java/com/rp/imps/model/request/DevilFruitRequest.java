package com.rp.imps.model.request;

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
