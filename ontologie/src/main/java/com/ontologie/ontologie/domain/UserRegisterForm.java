package com.ontologie.ontologie.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ontologie.ontologie.entities.Role;
import com.ontologie.ontologie.entities.User;

public class UserRegisterForm {
	
	@NotBlank
	//@Pattern(regexp = "^(+237) [2356789] [0-9]{2} [0-9]{2} [0-9]{2}$")
	private String phoneNumber;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String cpassword;
	
	private String firstname;
	@NotBlank
	private String lastname;
	@NotBlank
	private String town;
	@NotBlank
	private String district;
	@NotBlank
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserRegisterForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
	
	
	public User extractUser() {
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		user.setPhoneNumber(phoneNumber);
		user.setEmail(email);
		user.setAddress(String.format("%s/%s", town, district));
		return user;
	}
	
	public Role extractRole() {
		Role role = new Role();
		role.setName(this.role);
		return role;
	}
}
