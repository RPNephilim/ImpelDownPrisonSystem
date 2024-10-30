package com.rp.imps.controller;

import com.rp.imps.model.request.AreaRequest;
import com.rp.imps.model.response.AreaResponse;
import com.rp.imps.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AreaController {

    @Autowired
    AreaService service;

    @PostMapping(value = "")
    public ResponseEntity<AreaResponse> addArea(@RequestBody AreaRequest request){
        return new ResponseEntity<>(service.addArea(request), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeArea(@PathVariable String id){
        return new ResponseEntity<>(service.removeArea(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AreaResponse> getArea(@PathVariable String id){
        return new ResponseEntity<>(service.getArea(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AreaResponse> updateArea(@PathVariable String id, @RequestBody AreaRequest request){
        return new ResponseEntity<>(service.updateArea(id, request), HttpStatus.OK);
    }
}
