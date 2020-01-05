package com.ontologie.ontologie.repos;

import org.springframework.data.repository.CrudRepository;

import com.ontologie.ontologie.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByName(String name);
}
