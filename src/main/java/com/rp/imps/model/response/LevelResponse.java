package com.rp.imps.model.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LevelResponse {
    private String id;
    private String type;
    private String supervisor;
    private List<String> areas;
}
