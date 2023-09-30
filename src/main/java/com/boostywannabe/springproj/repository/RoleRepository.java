package com.boostywannabe.springproj.repository;

import com.boostywannabe.springproj.model.Role;
import com.boostywannabe.springproj.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, RoleType> {
}
