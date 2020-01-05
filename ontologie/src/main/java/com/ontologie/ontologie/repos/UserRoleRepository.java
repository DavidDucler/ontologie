package com.ontologie.ontologie.repos;

import org.springframework.data.repository.CrudRepository;

import com.ontologie.ontologie.entities.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

	UserRole findByUserId(Long id);
}
