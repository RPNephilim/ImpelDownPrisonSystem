package com.rp.imps.service.impl;

import com.rp.imps.model.entity.DevilFruit;
import com.rp.imps.model.enums.DevilFruitType;
import com.rp.imps.model.repository.DevilFruitRepository;
import com.rp.imps.model.request.DevilFruitRequest;
import com.rp.imps.model.response.DevilFruitResponse;
import com.rp.imps.service.DevilFruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DevilFruitServiceImpl implements DevilFruitService {

    @Autowired
    private DevilFruitRepository devilFruitRepository;

    @Override
    public DevilFruitResponse addDevilFruit(DevilFruitRequest devilFruitRequest) {
        DevilFruit devilFruit = DevilFruit.builder()
                .name(devilFruitRequest.getName())
                .alternateName(devilFruitRequest.getAlternateName())
                .type(DevilFruitType.valueOf(devilFruitRequest.getType()))
                .powerDescription(devilFruitRequest.getPowerDescription())
                .build();
        devilFruit = devilFruitRepository.save(devilFruit);
        return DevilFruitResponse.builder()
                .id(devilFruit.getId())
                .alternateName(devilFruit.getAlternateName())
                .name(devilFruit.getName())
                .powerDescription(devilFruit.getPowerDescription())
                .type(devilFruit.getType().getName())
                .build();
    }

    @Override
    public DevilFruitResponse getDevilFruit(String id) {
        DevilFruit devilFruit = devilFruitRepository.findById(id).orElseThrow(
                () -> {
                    log.error("DevilFruit = {} does not exists", id);
                    return new RuntimeException("DevilFruit does not exists");
                }
        );
        return DevilFruitResponse.builder()
                .id(devilFruit.getId())
                .alternateName(devilFruit.getAlternateName())
                .name(devilFruit.getName())
                .powerDescription(devilFruit.getPowerDescription())
                .type(devilFruit.getType().getName())
                .build();
    }

    @Override
    public String removeDevilFruit(String id) {
        devilFruitRepository.deleteById(id);
        if(devilFruitRepository.existsById(id)){
            return "Failed to remove devilFruit "+id;
        }
        return "Successfully removed devilFruit = "+id;
    }

    @Override
    public DevilFruitResponse updateDevilFruit(String id, DevilFruitRequest devilFruitRequest) {
        if(!devilFruitRepository.existsById(id)){
            log.error("DevilFruit = {} does not exist.", id);
            throw new RuntimeException("Devil Fruit not found");
        }
        DevilFruit devilFruit = DevilFruit.builder()
                .id(id)
                .name(devilFruitRequest.getName())
                .alternateName(devilFruitRequest.getAlternateName())
                .type(DevilFruitType.valueOf(devilFruitRequest.getType()))
                .powerDescription(devilFruitRequest.getPowerDescription())
                .build();
        devilFruit = devilFruitRepository.save(devilFruit);
        return DevilFruitResponse.builder()
                .id(devilFruit.getId())
                .alternateName(devilFruit.getAlternateName())
                .name(devilFruit.getName())
                .powerDescription(devilFruit.getPowerDescription())
                .type(devilFruit.getType().getName())
                .build();
    }
}
