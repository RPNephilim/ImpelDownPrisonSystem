package com.rp.imps.service.impl;

import com.rp.imps.model.entity.Level;
import com.rp.imps.model.enums.LevelType;
import com.rp.imps.model.repository.AreaRepository;
import com.rp.imps.model.repository.LevelRepository;
import com.rp.imps.model.request.LevelRequest;
import com.rp.imps.model.response.LevelResponse;
import com.rp.imps.service.LevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public LevelResponse addLevel(LevelRequest levelRequest) {
        Level level = Level.builder()
                .type(LevelType.valueOf(levelRequest.getType()))
                .areas(levelRequest.getAreas())
                .supervisor(levelRequest.getSupervisor())
                .build();
        level = levelRepository.save(level);
        return LevelResponse.builder()
                .areas(level.getAreas())
                .id(level.getId())
                .supervisor(level.getSupervisor())
                .type(level.getType().name())
                .build();
    }

    @Override
    public LevelResponse getLevel(String id) {
        Level level = levelRepository.findById(id).orElseThrow(
                () -> {
                    log.error("Level = {} does not exists", id);
                    return new RuntimeException("Level does not exists");
                }
        );
        return LevelResponse.builder()
                .areas(level.getAreas())
                .id(id)
                .supervisor(level.getSupervisor())
                .type(level.getType().name())
                .build();
    }

    @Override
    public String removeLevel(String id) {
        levelRepository.deleteById(id);
        if(levelRepository.existsById(id)){
            return "Failed to remove level "+id;
        }
        return "Successfully removed level = "+id;
    }

    @Override
    public LevelResponse updateLevel(String id, LevelRequest levelRequest) {
        Level level = levelRepository.findById(id).orElseThrow(
                () -> {
                    log.error("Level = {} does not exists", id);
                    return new RuntimeException("Level does not exists");
                }
        );
        BeanUtils.copyProperties(levelRequest, level);
        levelRepository.save(level);

        return LevelResponse.builder()
                .areas(levelRequest.getAreas())
                .id(id)
                .supervisor(levelRequest.getSupervisor())
                .type(levelRequest.getType())
                .build();
    }
}
