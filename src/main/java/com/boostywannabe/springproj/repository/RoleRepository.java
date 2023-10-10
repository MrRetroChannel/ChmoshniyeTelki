package com.boostywannabe.springproj.repository;

import com.boostywannabe.springproj.models.Role;
import com.boostywannabe.springproj.models.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, RoleType> {
}
