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
    AreaRepository repository;

    @Override
    public AreaResponse addArea(AreaRequest areaRequest) {
        Area area = new Area();
        AreaResponse areaResponse = new AreaResponse();
        BeanUtils.copyProperties(areaRequest, area);
        BeanUtils.copyProperties(repository.save(area), areaResponse);
        return areaResponse;
    }

    @Override
    public AreaResponse getArea(String id) {
        AreaResponse areaResponse = new AreaResponse();
        BeanUtils.copyProperties(repository.findById(id), areaResponse);
        return areaResponse;
    }

    @Override
    public String removeArea(String id) {
        repository.deleteById(id);
        if(repository.existsById(id)){
            log.error("Unable to remove area = {}", id);
            throw new RuntimeException("Unable to remove area = "+id);
        }
        return "Remove area successfully with id "+id;
    }

    @Override
    public AreaResponse updateArea(String id, AreaRequest areaRequest) {
        if(!repository.existsById(id)){
            log.error("Area = {} does not exists.", areaRequest);
            throw new RuntimeException("Provided area does not exists.");
        }
        Area area = new Area();
        AreaResponse areaResponse = new AreaResponse();
        BeanUtils.copyProperties(areaRequest, area);
        area.setId(id);
        BeanUtils.copyProperties(repository.save(area), areaResponse);
        return areaResponse;
    }
}
