package com.rp.imps.controller;

import com.rp.imps.model.request.OfficialRequest;
import com.rp.imps.model.response.OfficialResponse;
import com.rp.imps.service.OfficialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/official")
public class OfficialController {

    @Autowired
    OfficialService service;

    @PostMapping(value = "")
    public ResponseEntity<OfficialResponse> addOfficial(@RequestBody OfficialRequest request){
        return new ResponseEntity<>(service.addOfficial(request), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeOfficial(@PathVariable String id){
        return new ResponseEntity<>(service.removeOfficial(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OfficialResponse> getOfficial(@PathVariable String id){
        return new ResponseEntity<>(service.getOfficial(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OfficialResponse> updateOfficial(@PathVariable String id, @RequestBody OfficialRequest request){
        return new ResponseEntity<>(service.updateOfficial(id, request), HttpStatus.OK);
    }
}
