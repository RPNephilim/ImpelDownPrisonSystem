package com.rp.imps.controller;

import com.rp.imps.model.request.LevelRequest;
import com.rp.imps.model.response.LevelResponse;
import com.rp.imps.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LevelController {
    
    @Autowired
    LevelService service;

    @PostMapping(value = "")
    public ResponseEntity<LevelResponse> addLevel(@RequestBody LevelRequest request){
        return new ResponseEntity<>(service.addLevel(request), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removeLevel(@PathVariable String id){
        return new ResponseEntity<>(service.removeLevel(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LevelResponse> getLevel(@PathVariable String id){
        return new ResponseEntity<>(service.getLevel(id), HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<LevelResponse> updateLevel(@RequestBody LevelRequest request){
        return new ResponseEntity<>(service.updateLevel(request), HttpStatus.OK);
    }
}
