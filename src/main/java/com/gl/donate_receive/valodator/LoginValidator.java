package com.gl.donate_receive.valodator;

import com.gl.donate_receive.repository.UserRepository;
import com.gl.donate_receive.valodator.annotation.ValidLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class LoginValidator implements ConstraintValidator<ValidLogin, String> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(ValidLogin constraintAnnotation) {
	}

	@Override
	public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
		List<String> messages = new ArrayList<>();
		int loginMinLength = 3;
		int loginMaxLength = 320;

		if (login == null || login.trim().length() < loginMinLength || login.trim().length() > loginMaxLength) {
			messages.add(
				String.format(
					"login must have at least %s characters and no more %s", loginMinLength, loginMaxLength
				));
		}

		if (userRepository.findByLogin(login).isPresent()) {
			messages.add("login must must be unique");
		}

		if (messages.isEmpty()) {
			return true;
		}

		String messageTemplate = String.join(", ", messages);
		constraintValidatorContext.buildConstraintViolationWithTemplate(messageTemplate)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		return false;
	}

}
