package com.rp.imps.model.request;

import com.rp.imps.model.entity.Area;
import com.rp.imps.model.enums.LevelType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LevelRequest {
    private String type;
    private String supervisor;
    private List<Area> areas;
}
