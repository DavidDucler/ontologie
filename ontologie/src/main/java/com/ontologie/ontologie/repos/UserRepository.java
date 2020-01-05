package com.ontologie.ontologie.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ontologie.ontologie.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u from User u WHERE u.email = ?1 OR u.phoneNumber = ?1")
	public User retrieveByEmailOrPhoneNumber(String identifier);
	
	public User findByPhoneNumber(String number);
	public User findByEmail(String email);
}
