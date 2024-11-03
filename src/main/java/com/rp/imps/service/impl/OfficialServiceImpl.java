package com.rp.imps.service.impl;

import com.rp.imps.model.entity.Official;
import com.rp.imps.model.enums.Role;
import com.rp.imps.model.repository.AreaRepository;
import com.rp.imps.model.repository.OfficialRepository;
import com.rp.imps.model.request.OfficialRequest;
import com.rp.imps.model.response.OfficialResponse;
import com.rp.imps.service.OfficialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class OfficialServiceImpl implements OfficialService {

    @Autowired
    private OfficialRepository officialRepository;

    @Autowired
    private AreaRepository areaRepository;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public OfficialResponse addOfficial(OfficialRequest officialRequest) {
        if(!isValidRequest(officialRequest)){
            log.error("Invalid official request");
            throw new RuntimeException("Invalid official request");
        }
        Official official = Official.builder()
                .role(Role.valueOf(officialRequest.getRole()))
                .assignedArea(officialRequest.getAssignedArea())
                .shift(officialRequest.getShift())
                .joiningDate(LocalDate.parse(officialRequest.getJoiningDate(), dateTimeFormatter))
                .build();
        return null;
    }

    @Override
    public OfficialResponse getOfficial(String id) {
        Official official = officialRepository.findById(id).orElseThrow(
                () -> {
                    log.error("Official = {} does not exists", id);
                    return new RuntimeException("Official not found");
                }
        );
        OfficialResponse response = OfficialResponse.builder()
                .role(official.getRole().getName())
                .assignedArea(official.getAssignedArea())
                .shift(official.getShift())
                .joiningDate(official.getJoiningDate().toString())
                .build();
        return response;
    }

    @Override
    public String removeOfficial(String id) {
        officialRepository.deleteById(id);
        if(officialRepository.existsById(id)){
            log.error("Unable to remove official ={}", id);
            throw new RuntimeException("Unable to remove official ="+id);
        }
        return "Successfully removed official ="+id;
    }

    @Override
    public OfficialResponse updateOfficial(String id, OfficialRequest official) {
        if(!officialRepository.existsById(id)){
            log.error("Official = {} does not exists", id);
            throw new RuntimeException("Official not found");
        }
        return null;
    }

    private boolean isValidRequest(OfficialRequest officialRequest){
        //valid role check
        try {
            Role role = Role.valueOf(officialRequest.getRole());
        }catch (IllegalArgumentException e){
            log.error("Role does not exists", e);
            throw new RuntimeException("Role does not exists", e);
        }

        //valid area check
        if(!areaRepository.existsById(officialRequest.getAssignedArea())){
            return false;
        }

        //non overlapping shift check
        List<Official> officials = officialRepository.findAll();
        for(Official official : officials){
            if(official.getAssignedArea().equals(officialRequest.getAssignedArea())){
                return false;
            }
        }
        return true;
    }
}
