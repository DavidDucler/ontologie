package com.ontologie.ontologie.secutity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ontologie.ontologie.entities.User;
import com.ontologie.ontologie.entities.UserRole;
import com.ontologie.ontologie.repos.UserRepository;
import com.ontologie.ontologie.repos.UserRoleRepository;

@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserRoleRepository userRoleRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("line 2");
		User user = userRepository.retrieveByEmailOrPhoneNumber(username);
		if(user == null) {
									
			throw new UsernameNotFoundException("Email or phone number incorrect");
		}
		UserRole userRole = userRoleRepository.findByUserId(user.getId());
		return new UserInfo(user, userRole.getRole().getName());
	}

}
