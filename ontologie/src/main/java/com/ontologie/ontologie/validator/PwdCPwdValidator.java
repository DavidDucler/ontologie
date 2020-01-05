package com.ontologie.ontologie.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ontologie.ontologie.domain.UserRegisterForm;

public class PwdCPwdValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegisterForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserRegisterForm form = (UserRegisterForm) target;
		if(form.getPassword().equals(form.getCpassword()) == false)
			errors.rejectValue("Cpassword", "UserFormRegister.Cpassword", 
					null, "Password and confirmation password are differents");
		
	}

}
