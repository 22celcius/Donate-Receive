package com.gl.donate_receive.validator;

import com.gl.donate_receive.validator.annotation.ValidFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class FileValidator implements ConstraintValidator<ValidFile, MultipartFile> {

	@Value("${spring.validation.file.formats}")
	private List<String> formats;
	@Value("${spring.validation.file.size}")
	private long size;

	@Override
	public void initialize(ValidFile constraintAnnotation) {
	}

	@Override
	public boolean isValid(MultipartFile file, ConstraintValidatorContext constraintValidatorContext) {
		if (file == null) {
			return true;
		}

		List<String> messages = new ArrayList<>();

		var contentType = file.getContentType();
		if (!formats.contains(contentType)) {
			messages.add("File have to be one of formats: " + formats);
		}

		var fileSize = file.getSize();
		if (fileSize > size) {
			messages.add(String.format("File have to be less then: %s bytes", size));
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
