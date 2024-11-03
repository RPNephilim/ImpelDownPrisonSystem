package com.rp.imps.service;

import com.rp.imps.model.entity.DevilFruit;
import com.rp.imps.model.request.DevilFruitRequest;
import com.rp.imps.model.response.DevilFruitResponse;

public interface DevilFruitService {
    public DevilFruitResponse addDevilFruit(DevilFruitRequest DevilFruit);
    public DevilFruitResponse getDevilFruit(String id);
    public String removeDevilFruit(String id);
    public DevilFruitResponse updateDevilFruit(String id, DevilFruitRequest DevilFruit);
}
