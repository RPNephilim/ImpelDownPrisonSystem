package com.rp.imps.controller;

import com.rp.imps.model.request.DevilFruitRequest;
import com.rp.imps.model.response.DevilFruitResponse;
import com.rp.imps.service.DevilFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DevilFruitController {

    @Autowired
    DevilFruitService service;

    @PostMapping(value = "")
    public ResponseEntity<DevilFruitResponse> addDevilFruit(@RequestBody DevilFruitRequest request){
        return new ResponseEntity<>(service.addDevilFruit(request), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeDevilFruit(@PathVariable String id){
        return new ResponseEntity<>(service.removeDevilFruit(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DevilFruitResponse> getDevilFruit(@PathVariable String id){
        return new ResponseEntity<>(service.getDevilFruit(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DevilFruitResponse> updateDevilFruit(@PathVariable String id, @RequestBody DevilFruitRequest request){
        return new ResponseEntity<>(service.updateDevilFruit(id, request), HttpStatus.OK);
    }
}
