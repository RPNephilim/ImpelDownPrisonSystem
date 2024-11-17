package com.rp.imps.service.impl;

import com.rp.imps.model.entity.Prisoner;
import com.rp.imps.model.enums.ExecutionStatus;
import com.rp.imps.model.repository.AreaRepository;
import com.rp.imps.model.repository.LevelRepository;
import com.rp.imps.model.repository.PrisonerRepository;
import com.rp.imps.model.request.PrisonerRequest;
import com.rp.imps.model.response.PrisonerResponse;
import com.rp.imps.service.PrisonerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class PrisonerServiceImpl implements PrisonerService {

    @Autowired
    private PrisonerRepository prisonerRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private AreaRepository areaRepository;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public PrisonerResponse addPrisoner(PrisonerRequest prisonerRequest) {
        Prisoner prisoner = Prisoner.builder()
                .bounty(prisonerRequest.getBounty())
                .crimeDescription(prisonerRequest.getCrimeDescription())
                .affiliatedWith(prisonerRequest.getAffiliatedWith())
                .assignedLevel(prisonerRequest.getAssignedLevel())
                .assignedArea(prisonerRequest.getAssignedArea())
                .executionDate(LocalDate.parse(prisonerRequest.getExecutionDate(), dateTimeFormatter))
                .executionStatus(ExecutionStatus.valueOf(prisonerRequest.getExecutionStatus()))
                .assignedCell(prisonerRequest.getAssignedCell())
                .entryDate(LocalDate.parse(prisonerRequest.getEntryDate(), dateTimeFormatter))
                .build();
        setBasicDetails(prisoner, prisonerRequest);

        prisoner = prisonerRepository.save(prisoner);

        PrisonerResponse prisonerResponse = new PrisonerResponse();
        BeanUtils.copyProperties(prisonerRequest, prisonerResponse);
        prisonerResponse.setId(prisoner.getId());

        return prisonerResponse;
    }

    @Override
    public PrisonerResponse getPrisoner(String id) {
        Prisoner prisoner = prisonerRepository.findById(id).orElseThrow(
                ()-> {
                    log.error("Prisoner does not exists by id = {}", id);
                    throw new RuntimeException("Prisoner does not exists");
                }
        );

        PrisonerResponse prisonerResponse = new PrisonerResponse();
        BeanUtils.copyProperties(prisoner, prisonerResponse);
        prisonerResponse.setId(prisoner.getId());
        prisonerResponse.setExecutionDate(prisoner.getExecutionDate().toString());
        prisonerResponse.setExecutionStatus(prisoner.getExecutionStatus().getStatus());
        prisonerResponse.setEntryDate(prisoner.getEntryDate().toString());
        return prisonerResponse;
    }

    @Override
    public String removePrisoner(String id) {
        prisonerRepository.deleteById(id);
        if(prisonerRepository.existsById(id)){
            log.error("Unable to remove prisoner ={}", id);
            throw new RuntimeException("Unable to remove prisoner ="+id);
        }
        return "Successfully removed prisoner ="+id;
    }

    @Override
    public PrisonerResponse updatePrisoner(String id, PrisonerRequest prisonerRequest) {
        Prisoner prisoner = prisonerRepository.findById(id).orElseThrow(
                ()-> {
                    log.error("Prisoner does not exists by id = {}", id);
                    throw new RuntimeException("Prisoner does not exists");
                }
        );
        setBasicDetails(prisoner, prisonerRequest);
        prisoner.setExecutionDate(LocalDate.parse(prisonerRequest.getExecutionDate(), dateTimeFormatter));
        prisoner.setExecutionStatus(ExecutionStatus.valueOf(prisonerRequest.getExecutionStatus()));
        prisoner.setEntryDate(LocalDate.parse(prisonerRequest.getEntryDate(), dateTimeFormatter));
        PrisonerResponse prisonerResponse = new PrisonerResponse();
        BeanUtils.copyProperties(prisonerRequest, prisonerResponse);
        prisonerResponse.setId(id);

        return prisonerResponse;
    }

    private void setBasicDetails(Prisoner prisoner, PrisonerRequest prisonerRequest){
        prisoner.setFullName(prisonerRequest.getFullName());
        prisoner.setFatherName(prisonerRequest.getFatherName());
        prisoner.setMotherName(prisonerRequest.getMotherName());
        prisoner.setRace(prisonerRequest.getRace());
        prisoner.setDevilFruit(prisonerRequest.getDevilFruit());
        prisoner.setPhoto(prisonerRequest.getPhoto());
    }
}
