package com.rp.imps.security.controller;

import com.rp.imps.security.config.PrisonUserDetailsService;
import com.rp.imps.security.model.request.PrisonUserRequest;
import com.rp.imps.security.model.response.PrisonUserResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/prison/user")
@CrossOrigin(origins = "http://localhost:3000")
public class PrisonUserController {

    @Autowired
    private PrisonUserDetailsService userDetailsService;

    @PostMapping(value = "")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<PrisonUserResponse> registerUser(@RequestBody @Valid PrisonUserRequest user){
        log.info("in Controller");
        return new ResponseEntity<>(userDetailsService.registerUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{username}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> deleteUser(@PathVariable String username){
        return new ResponseEntity<>(userDetailsService.deleteUser(username), HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<PrisonUserResponse> getUser(@PathVariable String username){
        return new ResponseEntity<>(userDetailsService.getUser(username), HttpStatus.OK);
    }

    @PutMapping(value = "")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<PrisonUserResponse> updateUser(@RequestBody @Valid PrisonUserRequest user){
        return new ResponseEntity<>(userDetailsService.updateUser(user), HttpStatus.CREATED);
    }
}
