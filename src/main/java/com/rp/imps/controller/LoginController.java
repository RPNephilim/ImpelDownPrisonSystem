package com.rp.imps.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping(value = "/test")
    public ResponseEntity<String> testEndpoint(){
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
