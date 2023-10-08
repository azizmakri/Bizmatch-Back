package com.esprit.bizmatch.rest;

import com.esprit.bizmatch.persistence.entity.JwtRequest;
import com.esprit.bizmatch.persistence.entity.JwtResponse;
import com.esprit.bizmatch.services.Implementation.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}