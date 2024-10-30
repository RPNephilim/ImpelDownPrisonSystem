package com.rp.imps.service;

import com.rp.imps.model.entity.Level;
import com.rp.imps.model.request.LevelRequest;
import com.rp.imps.model.response.LevelResponse;

public interface LevelService {
    public LevelResponse addLevel(LevelRequest Level);
    public LevelResponse getLevel(String id);
    public String removeLevel(String id);
    public LevelResponse updateLevel(LevelRequest Level);
}
