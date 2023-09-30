package com.boostywannabe.springproj.configs;

import com.boostywannabe.springproj.model.Role;
import com.boostywannabe.springproj.model.RoleType;
import com.boostywannabe.springproj.model.User;
import com.boostywannabe.springproj.repository.RoleRepository;
import com.boostywannabe.springproj.service.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    UserContext userService;

    @Autowired
    RoleRepository roleService;

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> auth
                    .requestMatchers("/login", "/users/register")
                    .permitAll()
                    .requestMatchers("/users/getUsers")
                    .hasRole("ADMIN")
                    .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public void hardCodedUsers() {
        var admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");

        userService.addUser(admin);
        userService.setAdmin(admin);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}

