package com.rp.imps.service.impl;

import com.rp.imps.model.entity.DevilFruit;
import com.rp.imps.model.request.DevilFruitRequest;
import com.rp.imps.model.response.DevilFruitResponse;
import com.rp.imps.service.DevilFruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DevilFruitServiceImpl implements DevilFruitService {
    @Override
    public DevilFruitResponse addDevilFruit(DevilFruitRequest DevilFruit) {
        return null;
    }

    @Override
    public DevilFruitResponse getDevilFruit(String id) {
        return null;
    }

    @Override
    public String removeDevilFruit(String id) {
        return "";
    }

    @Override
    public DevilFruitResponse updateDevilFruit(DevilFruitRequest DevilFruit) {
        return null;
    }
}
