package com.ontologie.ontologie.domain.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontologie.ontologie.domain.UserRegisterForm;
import com.ontologie.ontologie.entities.Role;
import com.ontologie.ontologie.entities.User;
import com.ontologie.ontologie.entities.UserRole;
import com.ontologie.ontologie.repos.RoleRepository;
import com.ontologie.ontologie.repos.UserRepository;
import com.ontologie.ontologie.repos.UserRoleRepository;

@Component
public class AdminOp {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRoleRepository userRoleRepository;
	
	
	public void SaveUser(UserRegisterForm form) {
		User user = form.extractUser();
		user = userRepository.save(user);
		Role role = roleRepository.findByName(form.getRole());
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleRepository.save(userRole);
	}
	
}
