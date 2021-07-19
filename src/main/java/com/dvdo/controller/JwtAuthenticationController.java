package com.dvdo.controller;

import com.dvdo.model.request.JwtRequest;
import com.dvdo.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    private TokenService tokenService;

    @Autowired
    public JwtAuthenticationController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        return ResponseEntity.ok(tokenService.generateToken(authenticationRequest));
    }

}
