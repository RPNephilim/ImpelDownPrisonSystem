package com.rp.imps.service;

import com.rp.imps.model.entity.Official;
import com.rp.imps.model.request.OfficialRequest;
import com.rp.imps.model.response.OfficialResponse;

public interface OfficialService {
    public OfficialResponse addOfficial(Official official);
    public OfficialResponse getOfficial(OfficialRequest official);
    public String removeOfficial(OfficialRequest official);
    public OfficialResponse updateOfficial(OfficialRequest official);
}
