package com.rp.imps.service.impl;

import com.rp.imps.model.entity.Official;
import com.rp.imps.model.request.OfficialRequest;
import com.rp.imps.model.response.OfficialResponse;
import com.rp.imps.service.OfficialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OfficialServiceImpl implements OfficialService {

    @Override
    public OfficialResponse addOfficial(Official official) {
        return null;
    }

    @Override
    public OfficialResponse getOfficial(OfficialRequest official) {
        return null;
    }

    @Override
    public String removeOfficial(OfficialRequest official) {
        return "";
    }

    @Override
    public OfficialResponse updateOfficial(OfficialRequest official) {
        return null;
    }
}