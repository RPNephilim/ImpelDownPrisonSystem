package com.rp.imps.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @GetMapping(value = "/health-check")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> testEndpoint(){
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
