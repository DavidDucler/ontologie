package com.ontologie.ontologie.validator;

import org.springframework.validation.Errors;

import com.ontologie.ontologie.domain.UserRegisterForm;
import com.ontologie.ontologie.matchers.CMRPhoneMatcher;

public class CMRPhoneValidator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegisterForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserRegisterForm userRegisterForm = (UserRegisterForm) target;
		if(CMRPhoneMatcher.validate(userRegisterForm.getPhoneNumber()) == false)
			errors.rejectValue("phoneNumber", "userRegisterForm.phoneNumber",
					new String[] {userRegisterForm.getPhoneNumber()},
					null);
	}

}
