package com.rp.imps.service;

import com.rp.imps.model.entity.Official;
import com.rp.imps.model.request.OfficialRequest;
import com.rp.imps.model.response.OfficialResponse;

public interface OfficialService {
    public OfficialResponse addOfficial(OfficialRequest official);
    public OfficialResponse getOfficial(String id);
    public String removeOfficial(String id);
    public OfficialResponse updateOfficial(String id, OfficialRequest official);
}
