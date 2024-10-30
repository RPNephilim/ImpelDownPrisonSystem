package com.rp.imps.service;

import com.rp.imps.model.entity.Area;
import com.rp.imps.model.request.AreaRequest;
import com.rp.imps.model.response.AreaResponse;

public interface AreaService {
    public AreaResponse addArea(AreaRequest Area);
    public AreaResponse getArea(String id);
    public String removeArea(String id);
    public AreaResponse updateArea(String id, AreaRequest Area);
}
