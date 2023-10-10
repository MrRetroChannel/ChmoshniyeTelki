package com.boostywannabe.springproj.controllers;

import com.boostywannabe.springproj.requests.JwtAuthenticationResponse;
import com.boostywannabe.springproj.requests.SignInRequest;
import com.boostywannabe.springproj.requests.SignUpRequest;
import com.boostywannabe.springproj.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/signup")
    public JwtAuthenticationResponse signup(@RequestBody SignUpRequest request) {
        return authService.signUp(request);
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse signin(@RequestBody SignInRequest request) {
        return authService.signIn(request);
    }
}
