package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.models.Role;
import com.boostywannabe.springproj.models.RoleType;
import com.boostywannabe.springproj.models.User;
import com.boostywannabe.springproj.repository.UserRepository;
import com.boostywannabe.springproj.requests.JwtAuthenticationResponse;
import com.boostywannabe.springproj.requests.SignInRequest;
import com.boostywannabe.springproj.requests.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthenticationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authManager;

    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        User user = new User(request.getUsername(), request.getPassword(), Collections.singleton(new Role(RoleType.USER)));
        userService.addUser(user);

        var jwt = jwtService.generateToken(user);

        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        var user = userRepository.findByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);

        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
