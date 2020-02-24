package com.akp.eshoppingservice.repository;

import java.util.Optional;

import com.akp.eshoppingservice.models.ERole;
import com.akp.eshoppingservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
