package com.rp.imps.service.impl;

import com.rp.imps.model.entity.Area;
import com.rp.imps.model.repository.AreaRepository;
import com.rp.imps.model.request.AreaRequest;
import com.rp.imps.model.response.AreaResponse;
import com.rp.imps.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaRepository areaRepository;

    @Override
    public AreaResponse addArea(AreaRequest areaRequest) {
        Area area = new Area();
        BeanUtils.copyProperties(areaRequest, area);
        area = areaRepository.save(area);
        return AreaResponse.builder()
                .id(area.getId())
                .name(area.getName())
                .cells(area.getCells())
                .rooms(area.getRooms())
                .guardsAssigned(area.getGuardsAssigned())
                .build();
    }

    @Override
    public AreaResponse getArea(String id) {
        Area area = areaRepository.findById(id).orElseThrow(
                () -> {
                    log.error("Area = {} does not exists", id);
                    return new RuntimeException("Area not found");
                }
        );
        return AreaResponse.builder()
                .id(area.getId())
                .name(area.getName())
                .cells(area.getCells())
                .rooms(area.getRooms())
                .guardsAssigned(area.getGuardsAssigned())
                .build();
    }

    @Override
    public String removeArea(String id) {
        areaRepository.deleteById(id);
        if(areaRepository.existsById(id)){
            log.error("Unable to remove area = {}", id);
            throw new RuntimeException("Unable to remove area = "+id);
        }
        return "Removed area successfully with id "+id;
    }

    @Override
    public AreaResponse updateArea(String id, AreaRequest areaRequest) {
        Area area = areaRepository.findById(id).orElseThrow(
                () -> {
                    log.error("Area = {} does not exists", id);
                    return new RuntimeException("Area not found");
                }
        );
        BeanUtils.copyProperties(areaRequest, area);
        area = areaRepository.save(area);
        return AreaResponse.builder()
                .id(area.getId())
                .name(area.getName())
                .cells(area.getCells())
                .rooms(area.getRooms())
                .guardsAssigned(area.getGuardsAssigned())
                .build();
    }
}
