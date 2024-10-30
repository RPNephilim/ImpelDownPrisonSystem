package com.rp.imps.model.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DevilFruitResponse {
    private String id;
    private String type;
    private String name;
    private String alternateName;
    private String powerDescription;
}
