package com.ontologie.ontologie.secutity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import com.ontologie.ontologie.domain.UserSession;
import com.ontologie.ontologie.entities.User;
import com.ontologie.ontologie.repos.UserRepository;


public class AppAuthProvider implements AuthenticationProvider {

	@Autowired
	UserInfoService userService;
	
	@Autowired
	UserSession userSession;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		String identifier = token.getName();
		String password = token.getCredentials().toString();
		
		UserInfo userInfo = (UserInfo)userService.loadUserByUsername(identifier);
		
		if(BCrypt.checkpw(password, userInfo.getPassword()) == false) {
			throw new BadCredentialsException("Invalid password");
		}
		userSession.setUsername(userInfo.getUsername());
		userSession.setRole(userInfo.getRole());
		userSession.setEmail(userInfo.getEmail());
		return new UsernamePasswordAuthenticationToken(userInfo, null, userInfo.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
