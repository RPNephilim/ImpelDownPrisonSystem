package com.rp.imps.model.response;

import com.rp.imps.model.entity.Area;
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
    private List<Area> areas;
}