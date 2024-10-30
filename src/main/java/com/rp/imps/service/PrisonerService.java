package com.rp.imps.service;

import com.rp.imps.model.request.PrisonerRequest;
import com.rp.imps.model.response.PrisonerResponse;

public interface PrisonerService {
    public PrisonerResponse addPrisoner(PrisonerRequest Prisoner);
    public PrisonerResponse getPrisoner(String id);
    public String removePrisoner(String id);
    public PrisonerResponse updatePrisoner(PrisonerRequest Prisoner);
}
