package com.rp.imps.controller;

import com.rp.imps.model.request.PrisonerRequest;
import com.rp.imps.model.response.PrisonerResponse;
import com.rp.imps.service.PrisonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/prisoner")
public class PrisonerController {
    
    @Autowired
    PrisonerService service;

    @PostMapping(value = "")
    public ResponseEntity<PrisonerResponse> addPrisoner(@RequestBody PrisonerRequest request){
        return new ResponseEntity<>(service.addPrisoner(request), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removePrisoner(@PathVariable String id){
        return new ResponseEntity<>(service.removePrisoner(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PrisonerResponse> getPrisoner(@PathVariable String id){
        return new ResponseEntity<>(service.getPrisoner(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PrisonerResponse> updatePrisoner(@PathVariable String id, @RequestBody PrisonerRequest request){
        return new ResponseEntity<>(service.updatePrisoner(id, request), HttpStatus.OK);
    }
}
