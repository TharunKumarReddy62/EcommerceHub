package com.project.EcommerceHub.repositories;

import com.project.EcommerceHub.model.AppRole;
import com.project.EcommerceHub.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}