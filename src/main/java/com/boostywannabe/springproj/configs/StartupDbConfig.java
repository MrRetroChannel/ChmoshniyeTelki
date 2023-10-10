package com.boostywannabe.springproj.configs;

import com.boostywannabe.springproj.models.Role;
import com.boostywannabe.springproj.models.RoleType;
import com.boostywannabe.springproj.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StartupDbConfig {
    @Autowired
    RoleRepository roleService;

    @Bean
    public void insertAllRoles() {
        for (var i : RoleType.values())
            if (i.ordinal() != 0)
                roleService.save(new Role(i));
    }
}
