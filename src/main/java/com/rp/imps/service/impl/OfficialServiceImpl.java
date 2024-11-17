package com.rp.imps.service.impl;

import com.rp.imps.model.entity.Official;
import com.rp.imps.model.repository.AreaRepository;
import com.rp.imps.model.repository.OfficialRepository;
import com.rp.imps.model.request.OfficialRequest;
import com.rp.imps.model.response.OfficialResponse;
import com.rp.imps.security.model.enums.Role;
import com.rp.imps.service.OfficialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        Official official = Official.builder()
                .role(Role.valueOf(officialRequest.getRole()))
                .assignedArea(officialRequest.getAssignedArea())
                .shift(officialRequest.getShift())
                .joiningDate(LocalDate.parse(officialRequest.getJoiningDate(), dateTimeFormatter))
                .build();
        setBasicDetails(official, officialRequest);
        official = officialRepository.save(official);

        OfficialResponse officialResponse = new OfficialResponse();
        BeanUtils.copyProperties(officialRequest, officialResponse);
        officialResponse.setId(official.getId());

        return officialResponse;
    }

    @Override
    public OfficialResponse getOfficial(String id) {
        Official official = officialRepository.findById(id).orElseThrow(
                () -> {
                    log.error("Official = {} does not exists", id);
                    return new RuntimeException("Official not found");
                }
        );
        OfficialResponse officialResponse = new OfficialResponse();
        BeanUtils.copyProperties(official, officialResponse);
        officialResponse.setId(official.getId());
        officialResponse.setRole(official.getRole().getName());
        officialResponse.setJoiningDate(official.getJoiningDate().toString());

        return officialResponse;
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

    //ToDo: update only passed info
    @Override
    public OfficialResponse updateOfficial(String id, OfficialRequest officialRequest) {
        Official official = officialRepository.findById(id).orElseThrow(
                () -> {
                    log.error("Official = {} does not exists", id);
                    return new RuntimeException("Official not found");
                }
        );

        setBasicDetails(official, officialRequest);
        official.setRole(Role.valueOf(officialRequest.getRole()));
        official.setAssignedArea(officialRequest.getAssignedArea());
        official.setShift(officialRequest.getShift());
        official.setJoiningDate(LocalDate.parse(officialRequest.getJoiningDate(), dateTimeFormatter));
        officialRepository.save(official);

        OfficialResponse officialResponse = new OfficialResponse();
        BeanUtils.copyProperties(officialRequest, officialResponse);
        officialResponse.setId(id);

        return officialResponse;
    }


    private void setBasicDetails(Official official, OfficialRequest officialRequest){
        official.setFullName(officialRequest.getFullName());
        official.setFatherName(officialRequest.getFatherName());
        official.setMotherName(officialRequest.getMotherName());
        official.setRace(officialRequest.getRace());
        official.setDevilFruit(officialRequest.getDevilFruit());
        official.setPhoto(officialRequest.getPhoto());
    }
}
