package com.boostywannabe.springproj.controllers;

import com.boostywannabe.springproj.model.Role;
import com.boostywannabe.springproj.model.User;
import com.boostywannabe.springproj.service.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.util.matcher.IpAddressServerWebExchangeMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserContext service;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        System.out.println(user.getUsername());
        return service.addUser(user) ?
                ResponseEntity.ok("Заебатенько") :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Логин занят");
    }

    @GetMapping("/register")
    public ResponseEntity<?> registerPage(@RequestParam String username, @RequestParam String password) {
        var user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return service.addUser(user) ?
                ResponseEntity.ok("Заебатенько") :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Логин занят");
    }

    @PostMapping("/check")
    public ResponseEntity<?> checkCredentials(@RequestBody User user) {
        var load = service.loadUserByUsername(user.getUsername());

        return bCryptPasswordEncoder.encode(user.getPassword()).equals(load.getPassword()) ?
                ResponseEntity.status(HttpStatus.OK).body("Все ок ебанат") :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Не все ок ебенкатй");
    }


    @GetMapping("/getUsers")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(service.getUsers());
    }
}