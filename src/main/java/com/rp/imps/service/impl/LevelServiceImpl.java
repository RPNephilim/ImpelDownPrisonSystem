package com.rp.imps.service.impl;

import com.rp.imps.model.entity.Level;
import com.rp.imps.model.request.LevelRequest;
import com.rp.imps.model.response.LevelResponse;
import com.rp.imps.service.LevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LevelServiceImpl implements LevelService {
    @Override
    public LevelResponse addLevel(LevelRequest Level) {
        return null;
    }

    @Override
    public LevelResponse getLevel(String id) {
        return null;
    }

    @Override
    public String removeLevel(String id) {
        return "";
    }

    @Override
    public LevelResponse updateLevel(LevelRequest Level) {
        return null;
    }
}
