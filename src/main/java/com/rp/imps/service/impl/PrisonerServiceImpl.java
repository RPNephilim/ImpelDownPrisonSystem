package com.rp.imps.service.impl;

import com.rp.imps.model.entity.Prisoner;
import com.rp.imps.model.request.PrisonerRequest;
import com.rp.imps.model.response.PrisonerResponse;
import com.rp.imps.service.PrisonerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrisonerServiceImpl implements PrisonerService {
    @Override
    public PrisonerResponse addPrisoner(PrisonerRequest Prisoner) {
        return null;
    }

    @Override
    public PrisonerResponse getPrisoner(String id) {
        return null;
    }

    @Override
    public String removePrisoner(String id) {
        return "";
    }

    @Override
    public PrisonerResponse updatePrisoner(PrisonerRequest Prisoner) {
        return null;
    }
}
