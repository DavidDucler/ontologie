package com.ontologie.ontologie.restctrls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ontologie.ontologie.domain.JsonResponse;
import com.ontologie.ontologie.domain.UserRegisterForm;
import com.ontologie.ontologie.domain.db.AdminOp;
import com.ontologie.ontologie.repos.RoleRepository;
import com.ontologie.ontologie.repos.UserRepository;
import com.ontologie.ontologie.validator.CMRPhoneValidator;
import com.ontologie.ontologie.validator.PwdCPwdValidator;

@RestController
public class AdminController {

	
	@Autowired
	AdminOp adminOp;
	
	@RequestMapping(value="/addUser", method = RequestMethod.POST, 
			produces="application/json; charset=utf-8" )
	public Object addUser (@Valid UserRegisterForm userRegister, BindingResult result) {
		
		CMRPhoneValidator validator = new CMRPhoneValidator();
		validator.validate(userRegister, result);
		PwdCPwdValidator cPwdValidator = new PwdCPwdValidator();
		cPwdValidator.validate(userRegister, result);
		JsonResponse response = new JsonResponse();
		if(result.hasErrors()) {
			response.setErrorMessage(true);
			response.setTitle("Register failed");
			List<String> messages = new ArrayList<String>();
		
			for (FieldError field :  result.getFieldErrors()) {
				messages.add(String.format("%s - %s", field.getCodes(), field.getDefaultMessage()));
			}
			response.setMessages(messages);
		}
		else {
			response.setErrorMessage(false);
			ArrayList<String> message = new ArrayList<>();
			message.add("User was added");
			response.setMessages(message);
			
			adminOp.SaveUser(userRegister);
			
		}
		return response;
	}
}
